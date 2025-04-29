terraform {

  # terraform init -migrate-state
  # backend "azurerm" {
  #   subscription_id     = "d4fa161c-91b5-4d9b-9831-a9e1061b4ac2"
  #   resource_group_name = "rg-little-pm"
  #   key                 = "terraform.tfstate"
  # }

  required_providers {
    azapi = {
      source  = "azure/azapi"
      version = ">=2.0"
    }
    azurerm = {
      source  = "hashicorp/azurerm"
      version = ">= 4.0.0, < 5.0.0"
    }
    random = {
      source  = "hashicorp/random"
      version = "~> 3.5"
    }
    time = {
      source  = "hashicorp/time"
      version = "0.12.1"
    }
    tls = {
      source  = "hashicorp/tls"
      version = "~> 4.0"
    }
  }
}

provider "azurerm" {
  subscription_id = "d4fa161c-91b5-4d9b-9831-a9e1061b4ac2"
  features {}
}
