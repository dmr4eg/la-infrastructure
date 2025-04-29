# module "psql-secret" {
#   source      = "../secret/"
#   kv_id       = azurerm_key_vault.this.id
#   secret_name = "psql-secret"
# }

# resource "azurerm_postgresql_flexible_server" "psql" {
#   name                          = "psql-little-pm"
#   location                      = "westeurope"
#   resource_group_name           = data.azurerm_resource_group.this.name
#   version                       = "15"
#   public_network_access_enabled = true # TODO false
#   administrator_login           = module.psql-secret.username
#   administrator_password        = module.psql-secret.password
#   authentication {
#     active_directory_auth_enabled = false
#     password_auth_enabled         = true
#   }
#   zone              = "3"
#   auto_grow_enabled = true

#   storage_mb   = 32768
#   storage_tier = "P30"
#   tags         = {}


#   backup_retention_days        = 7
#   geo_redundant_backup_enabled = false

#   sku_name = "B_Standard_B1ms"

#   lifecycle {
#     prevent_destroy = true
#   }
# }

# # resource "azurerm_postgresql_flexible_server_configuration" "psql" {
# #   name      = "azure.extensions"
# #   server_id = azurerm_postgresql_flexible_server.psql.id
# #   value     = "AZURE_AI,VECTOR"
# # }

# resource "azurerm_private_dns_a_record" "psql-at" {
#   name                = "@"
#   zone_name           = azurerm_private_dns_zone.psql.name
#   resource_group_name = data.azurerm_resource_group.this.name
#   ttl                 = 300
#   records = [
#     azurerm_private_endpoint.psql.private_service_connection[0].private_ip_address
#   ]
# }
