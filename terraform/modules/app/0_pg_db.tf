# variable "psql_server_id" {
#   type        = string
#   description = "The ID of the PostgreSQL server."
# }

# resource "azurerm_postgresql_flexible_server_database" "this" {
#   name      = "little-pm-db"
#   server_id = var.psql_server_id
#   charset   = "UTF8"
#   collation = "en_US.utf8"

#   # prevent the possibility of accidental data loss
#   lifecycle {
#     prevent_destroy = true
#   }
# }
