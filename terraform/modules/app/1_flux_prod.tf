variable "aks_id" {
  type        = string
  description = "ID of the azurerm_kubernetes_cluster from 'shared' module."
}

variable "git_repository_url" {
  type = string
}

variable "git_reference_type" {
  type = string
}

variable "git_reference_value" {
  type = string
}

variable "git_kustomizations_path" {
  type = string
}


resource "azurerm_kubernetes_flux_configuration" "apps" {
  name       = "flux-apps"
  cluster_id = var.aks_id
  namespace  = "flux-system"
  scope      = "cluster"

  git_repository {
    url                      = var.git_repository_url
    reference_type           = var.git_reference_type
    reference_value          = var.git_reference_value
    sync_interval_in_seconds = 20
  }

  kustomizations {
    name                     = "prod"
    path                     = var.git_kustomizations_path
    sync_interval_in_seconds = 10
  }

  depends_on = [
  ]
}


