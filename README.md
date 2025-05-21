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

The objective of this thesis is the design and development of a platform specifically for elementary to middle
school-aged children to guide them through the process of creating and managing projects in just 7 days.
The platform will be accessible online and will follow a structured structure where kids are assigned daily tasks
from Day 1 to Day 7,progressing towards the final result of a project.

Additionally, the platform will educate the basics of financial concepts, assisting children in understanding the
value of financial resources as a part of their projects. It will let them calculate budgets, track expenses and
gain management skills practically and engagingly.
#### Goals of this thesis:
Conduct research and analysis of this field.
Launch a prototype of the platform with key features and a user-tested interface.
Provide educational tools for children to learn project management skills and the basics of intuitive financial
planning.

#### Platform features:
####  Project Creation Tools:
🟢Templates for creating various types of projects
🟢Customisable project themes and categories.
#### Project Management Tools:
🟢Daily task assignment and tracking for each of the 7 days.
🟢Notifications regarding task status and progress
#### Financial Planning Module:
🟢Basic budgeting tools with automatic calculations.
🟢Templates for financial goal-setting and expense tracking.
#### Gamification and Engagement:
🟢Simple and child-friendly interface
🟢Reward system for task completion (badges, progress bars, achievements etc.)
Interactive tutorials and tips to guide children through project management steps.
🟢Options for children to collaborate with friends or classmates on mutual projects.