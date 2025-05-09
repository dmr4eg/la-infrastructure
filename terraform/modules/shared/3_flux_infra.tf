variable "git_repository_url" {
  type = string
}

variable "git_reference_type" {
  type = string
}

variable "git_reference_value" {
  type = string
}

variable "flux_path_controllers" {
  type = string
}

variable "flux_path_configs" {
  type = string
}

variable "flux_path_services" {
  type = string
}

resource "azurerm_kubernetes_cluster_extension" "this" {
  name           = "flux"
  cluster_id     = azurerm_kubernetes_cluster.this.id
  extension_type = "microsoft.flux"
}

resource "azurerm_kubernetes_flux_configuration" "infra" {
  name       = "flux-infra"
  cluster_id = azurerm_kubernetes_cluster.this.id
  namespace  = "flux-system"
  scope      = "cluster"

  git_repository {
    url             = var.git_repository_url
    reference_type  = var.git_reference_type
    reference_value = var.git_reference_value
    # ssh_private_key_base64   = base64encode(module.ssh-secret.private_key)
    sync_interval_in_seconds = 20
  }

  kustomizations {
    name                     = "controllers"
    sync_interval_in_seconds = 20
    path                     = var.flux_path_controllers
  }

  kustomizations {
    name                     = "configs"
    sync_interval_in_seconds = 20
    path                     = var.flux_path_configs
    depends_on = [
      "controllers"
    ]
  }

  kustomizations {
    name                     = "services"
    sync_interval_in_seconds = 20
    path                     = var.flux_path_services
    depends_on = [
      "configs"
    ]
  }
}
