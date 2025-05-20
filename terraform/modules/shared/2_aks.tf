resource "azurerm_role_assignment" "net_contributor" {
  scope                = data.azurerm_resource_group.this.id
  principal_id         = azurerm_user_assigned_identity.this.principal_id
  role_definition_name = "Network Contributor"
}

resource "azurerm_role_assignment" "dns_zone_contributor" {
  scope                = data.azurerm_dns_zone.this.id
  principal_id         = azurerm_user_assigned_identity.this.principal_id
  role_definition_name = "DNS Zone Contributor"
}

resource "azurerm_role_assignment" "keyvault_secrets_user" {
  scope                = azurerm_key_vault.this.id
  principal_id         = azurerm_user_assigned_identity.this.principal_id
  role_definition_name = "Key Vault Secrets User"
}

resource "azurerm_role_assignment" "acr_pull" {
  scope                            = azurerm_container_registry.this.id
  principal_id                     = azurerm_user_assigned_identity.this.principal_id
  skip_service_principal_aad_check = true
  role_definition_name             = "AcrPull"
}

resource "azurerm_kubernetes_cluster" "this" {
  name                      = "aks-la"
  location                  = data.azurerm_resource_group.this.location
  resource_group_name       = data.azurerm_resource_group.this.name
  dns_prefix                = "aks-la"
  private_cluster_enabled   = false
  kubernetes_version        = "1.30.9"
  automatic_upgrade_channel = "stable"
  node_resource_group       = "rg-la-aks"
  sku_tier                  = "Free"
  azure_policy_enabled      = false

  oidc_issuer_enabled       = true
  workload_identity_enabled = true

  storage_profile {
    blob_driver_enabled = true
    disk_driver_enabled = true
    file_driver_enabled = true
  }

  workload_autoscaler_profile {
    keda_enabled                    = true
    vertical_pod_autoscaler_enabled = true
  }

  azure_active_directory_role_based_access_control {
    tenant_id              = data.azurerm_client_config.this.tenant_id
    azure_rbac_enabled     = true
    admin_group_object_ids = []
  }
  local_account_disabled = false

  network_profile {
    network_plugin      = "azure"
    network_plugin_mode = "overlay"
  }

  kubelet_identity {
    user_assigned_identity_id = azurerm_user_assigned_identity.this.id
    client_id                 = azurerm_user_assigned_identity.this.client_id
    object_id                 = azurerm_user_assigned_identity.this.principal_id
  }

  default_node_pool {
    name                        = "system"
    temporary_name_for_rotation = "tmpsystem"
    orchestrator_version        = "1.30.9"
    scale_down_mode             = "Delete"
    type                        = "VirtualMachineScaleSets"
    os_sku                      = "Ubuntu"
    max_pods                    = 150
    auto_scaling_enabled        = "true"
    # node_count                  = 1
    min_count = 1
    max_count = 2
    node_labels = {
      agentpool = "system"
    }

    vm_size = "Standard_A2_v2"
  }

  identity {
    type         = "UserAssigned"
    identity_ids = [azurerm_user_assigned_identity.this.id]
  }

  lifecycle {
    prevent_destroy = true
    ignore_changes = [
      default_node_pool[0].upgrade_settings,
    ]
  }

  depends_on = [
    azurerm_user_assigned_identity.this,
    azurerm_role_assignment.net_contributor,
    azurerm_role_assignment.dns_zone_contributor
  ]

}

