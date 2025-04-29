resource "azurerm_user_assigned_identity" "this" {
  name                = "id-little-pm"
  location            = data.azurerm_resource_group.this.location
  resource_group_name = data.azurerm_resource_group.this.name
}

resource "azurerm_role_assignment" "aks_mio" {
  principal_id                     = azurerm_user_assigned_identity.this.principal_id
  scope                            = data.azurerm_resource_group.this.id
  role_definition_name             = "Managed Identity Operator"
  skip_service_principal_aad_check = true
}
