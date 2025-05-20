data "azurerm_client_config" "this" {}

data "azurerm_resource_group" "this" { name = "rg-la" }

data "azurerm_dns_zone" "this" {
  name                = "localhost"
  resource_group_name = data.azurerm_resource_group.this.name
}
