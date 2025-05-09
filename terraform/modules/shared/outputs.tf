output "aks_id" {
  value       = azurerm_kubernetes_cluster.this.id
  description = "id of the aks"
}
