resource "azurerm_dns_cname_record" "wildcard" {
  name                = "*"
  zone_name           = data.azurerm_dns_zone.this.name
  resource_group_name = data.azurerm_dns_zone.this.resource_group_name
  ttl                 = 300
  record              = "laaks.${azurerm_kubernetes_cluster.this.location}.cloudapp.azure.com"
}
