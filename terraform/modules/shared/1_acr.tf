resource "azurerm_container_registry" "this" {
  name                     = "littlepmacr"
  resource_group_name      = data.azurerm_resource_group.this.name
  location                 = data.azurerm_resource_group.this.location
  sku                      = "Basic"
  admin_enabled            = true
  zone_redundancy_enabled  = false
  retention_policy_in_days = null

  tags = {
    environment = "dev"
    app         = "little-pm"
    owner       = "dmr4eg"
  }
}
