output "aks_id" {
  value       = azurerm_kubernetes_cluster.this.id
  description = "ID of the AKS cluster."
}
