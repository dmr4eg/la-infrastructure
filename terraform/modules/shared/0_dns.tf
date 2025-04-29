

# TODO 
# *.nonprod.da.dnai.ai ->  nonprod
# some.dev.nonprod.dnai.ai/<app>/api
# some.test.nonprod.dnai.ai/<app>/api

# *.da.dnai.ai -> prod 
# soma.demo.da.dnai.ai done
# soma.da.dnai.ai

resource "azurerm_dns_cname_record" "wildcard" {
  name                = "*"
  zone_name           = data.azurerm_dns_zone.this.name
  resource_group_name = data.azurerm_dns_zone.this.resource_group_name
  ttl                 = 300
  record              = "littlepmaks.${azurerm_kubernetes_cluster.this.location}.cloudapp.azure.com"
}
