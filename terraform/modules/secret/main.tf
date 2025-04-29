variable "kv_id" {
  type = string
}

variable "secret_name" {
  type = string
}

resource "random_pet" "this" {
  length    = 2
  separator = ""
}

resource "random_password" "this" {
  length           = 16
  special          = true
  override_special = "_.=+-<>"
}

resource "azurerm_key_vault_secret" "username" {
  key_vault_id = var.kv_id
  name         = "${var.secret_name}-username"
  value        = random_pet.this.id
}

resource "azurerm_key_vault_secret" "password" {
  key_vault_id = var.kv_id
  name         = "${var.secret_name}-password"
  value        = random_password.this.result
}

output "username" {
  sensitive = true
  value     = random_pet.this.id
}

output "password" {
  sensitive = true
  value     = random_password.this.result
}
