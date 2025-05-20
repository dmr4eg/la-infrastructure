# learning application



terraform/
├── modules/
│ ├─ app/
│ │   └─ flux_prod.tf  #  FluxCD app layer
│ └─ shared/
│       └─ ... # DNS, K8S, FluxCD infrastructure layer modules 
└── envs/
    └─ prod/
          ├─ provider.tf   # Terraform providers    
          └─ main.tf   #  Initialization file  