module "prod" {
  source = "../../modules/shared"

  git_repository_url  = "https://github.com/dmr4eg/la-infrastructure.git"
  git_reference_type  = "branch"
  git_reference_value = "main"

  flux_path_configs     = "./flux/infrastructure/configs"
  flux_path_controllers = "./flux/infrastructure/controllers"
  flux_path_services    = "./flux/infrastructure/services"
}

module "app" {
  source = "../../modules/app"

  git_repository_url      = "https://github.com/dmr4eg/la-infrastructure.git"
  git_reference_type      = "branch"
  git_reference_value     = "main"
  git_kustomizations_path = "./flux/apps/overlays/prod"

  aks_id = module.prod.aks_id
}
