# API DATA SCHEME

project_dto {
    blueprint: project_blueprint
    instance: project_instance
}

project_blueprint {
    project_blueprint_uuid: UUID
    poster_url: string    
    welcome_video_url: string
    title: string
    description: string
    difficulty: enum (easy, medium, hard)
    style: enum (dyi, ready_made)
}

project_days_mapper {
    project_blueprint: project_blueprint_uuid    
    day: day_blueprint_uuid
    order: int
}

project_instance {
    project_blueprint_uuid: UUID
    user_uuid: UUID
    status: enum (in_progress, completed)
    start_date: datetime
    end_date: datetime
    feedback: string
    what_went_well: string
}

project_finance {
project_blueprint_uuid: UUID    
user_uuid: UUID
investor_gave: float
investor_return: float
spent_budget: float
toys_planned: float
toys_sold: float
toys_left: float
members_budged: float
profit: float
expense_amount: float
calculated_budget: float
items_cost: float
recommended_price: float
price_per_item: float
sold_price: float
}

project_members{
    project_blueprint_uuid: UUID
    user_uuid: UUID
    member_name: string
}

day_dto{
    blueprint: day_blueprint
    instance: day_instance
}

day_blueprint{
    day_blueprint_uuid: UUID
    title: string
    description: string
    text: string
}

day_components_mapper{
    day_blueprint_uuid: UUID
    day_component_uuid: UUID
    type: enum (task_blueprint, form_blueprint, media)
}

day_instance{
    day_blueprint_uuid: UUID
    user_uuid: UUID
    status: enum(in_progress, completed, not_started)
}

task_dto{
    blueprint: task_blueprint
    progress: task_instance
}

task_blueprint{
    task_blueprint_uuid: UUID
    title: string
    description: string
}

task_instance{
    task_blueprint_uuid: UUID    
    user_uuid: UUID
    status: boolean
}

form_dto{
    blueprint: form_blueprint
    instance: form_instance
}

form_blueprint{
    form_blueprint_uuid: UUID
    title: string 
    description: string
    callback_url: string
}

form_field_mapper{
    form_blueprint_uuid: UUID
    form_field: form_field_uuid    
    order: int
}

form_field{
    form_field_uuid: UUID
    input_type: enum (text, number, file)
    required: boolean  
    title: string
    description: string
}

form_instance{
    form_blueprint_uuid: UUID
    user_uuid: UUID
    status: boolean
}

media{
    mediaUUID: UUID
    type: enum (video, image)
    title: string
    description: string
}



# API SYNTAX NOTATION

HERE IS AN API SYNTAX NOTATION:
HTTP_METHOD[HTTP_HEADERS](URL_QUERY_PARAMS){REQUEST_BODY} /resource_path/{id} -> {RESPONSE_BODY} # Description


# projects
GET[](?limit&offset){}                          /projects -> 200 [{project_blueprint}]                          # List project blueprints (paginated)
POST[admin_jwt](){project_blueprint}            /projects -> 200 {project_blueprint}                            # Create new blueprint
GET[](){}                                       /projects/{project_blueprint_uuid} -> 200 {project_blueprint}             # Get blueprint details
PUT[admin_jwt](){project_blueprint}             /projects/{project_blueprint_uuid} -> 200 {project_blueprint}             # Update blueprint
DELETE[admin_jwt](){}                           /projects/{project_blueprint_uuid} -> 204 No Content                      # Delete blueprint

# days mapping
GET[](?limit&offset){}                          /projects/{project_blueprint_uuid}/days -> 200 [{project_days_mapper}]    # Get linked days (paginated)
POST[admin_jwt](day_blueprint_uuid, order){}    /projects/{project_blueprint_uuid}/days -> 200 {project_days_mapper}      # Link day to project
DELETE[admin_jwt](day_blueprint_uuid){}         /projects/{project_blueprint_uuid}/days -> 204 No Content                 # Unlink day from project

# days
GET[](?limit&offset){}                          /days -> 200 [{day_blueprint}]                                   # List day templates (paginated)
POST[admin_jwt](){day_blueprint}                /days -> 200 {day_blueprint}                                     # Create day template
GET[](){}                                       /days/{day_blueprint_uuid} -> 200 {day_blueprint}                          # Get day template details
PUT[admin_jwt](){day_blueprint}                 /days/{day_blueprint_uuid} -> 200 {day_blueprint}                          # Update day template
DELETE[admin_jwt](){}                           /days/{day_blueprint_uuid} -> 204 No Content                               # Delete day template

# component mapping
GET[](?limit&offset){}                          /days/{day_blueprint_uuid}/components -> 200 [{day_components_mapper}]          # List day components (paginated)
POST[admin_jwt](){component_uuid, type}         /days/{day_blueprint_uuid}/components -> 200 {day_components_mapper}            # Add component to day
DELETE[admin_jwt](){component_uuid}             /days/{day_blueprint_uuid}/components -> 204 No Content                         # Remove component from day

# media
POST[admin_jwt](){media}                        /media -> {media}                                     # Upload new media
GET[](){}                                       /media/{media_uuid} -> 200 {media}                     # Get media metadata
PUT[admin_jwt](){media}                         /media/{media_uuid} -> 200 {media}                     # Update media metadata
DELETE[admin_jwt](){}                           /media/{media_uuid} -> 204 No Content                       # Delete media

# tasks
POST[admin_jwt](){task_blueprint}               /tasks -> 200 {task_blueprint}                                   # Create task template
GET[](?limit&offset){}                          /tasks -> 200 [{task_blueprint}]                               # List task templates (paginated)
GET[](){}                                       /tasks/{task_blueprint_uuid} -> 200 {task_blueprint}                      # Get task template
PUT[admin_jwt](){task_blueprint}                /tasks/{task_blueprint_uuid} -> 200 {task_blueprint}                      # Update task template
DELETE[admin_jwt](){}                           /tasks/{task_blueprint_uuid} -> 204 No Content                        # Delete task template

# forms
POST[admin_jwt](){form_blueprint}               /forms -> 200 {form_blueprint}                                              # Create form template
GET[](?limit&offset){}                          /forms -> 200 [{form_blueprint}]                                            # List form templates (paginated)
GET[](){}                                       /forms/{form_blueprint_uuid} -> 200 {form_blueprint}                      # Get form template
PUT[admin_jwt](){form_blueprint}                /forms/{form_blueprint_uuid} -> 200 {form_blueprint}                      # Update form template
DELETE[admin_jwt](){}                           /forms/{form_blueprint_uuid} -> 204 No Content                        # Delete form template

# form fields
POST[admin_jwt](form_field_uuid, order){}       /forms/{form_blueprint_uuid}/fields -> 200 [{form_field_mapper}]                    # Add field to form
GET[](?limit&offset){}                          /forms/{form_blueprint_uuid}/fields -> 200 [{form_field_mapper}]                 # List form fields
GET[](){}                                       /forms/{form_blueprint_uuid}/fields/{field_uuid} -> 200 {form_field}      # Get field details
PUT[admin_jwt](){field_data}                    /forms/{form_blueprint_uuid}/fields/{field_uuid} -> 200 {form_field}      # Update field
DELETE[admin_jwt](){}                           /forms/{form_blueprint_uuid}/fields/{field_uuid} -> 204 No Content   # Remove field

# Project instance (User-specific implementations)
GET[user_jwt](?limit&offset){}                          /user/{user_uuid}/project  -> 200 [{project_dto}]  # List user's projects
POST[user_jwt](project_blueprint_uuid){}                /user/{user_uuid}/project -> 200 {project_dto}  # Create new project instance
GET[user_jwt](){}                                       /user/{user_uuid}/project/{project_blueprint_uuid} -> 200 {project_dto} # Get project instance
PUT[user_jwt](){project_instance}                       /user/{user_uuid}/project/{project_blueprint_uuid} -> 200 {project_dto} # Update project instance

# Day instance (User progress tracking)
GET[user_jwt](?limit&offset){}                          /user/{user_uuid}/day/ -> 200 [{day_dto}] # List user's day progress
GET[user_jwt](){}                                       /user/{user_uuid}/day/{day_blueprint_uuid} -> 200 {day_dto} # Get day status   
PUT[user_jwt](){day_instance}                           /user/{user_uuid}/day/{day_blueprint_uuid} -> 200 {day_dto} # Update day status

# Task instance (User completion tracking)
GET[user_jwt](?limit&offset){}                          /user/{user_uuid}/task/ -> 200 [{task_dto}] # List user's task progress
GET[user_jwt](){}                                       /user/{user_uuid}/task/{task_blueprint_uuid} -> 200 {task_dto} # Get task status
PUT[user_jwt](){day_instance}                           /user/{user_uuid}/task/{task_blueprint_uuid}  -> 200 {task_dto} # Update task status

# Form instance (User submissions)
GET[user_jwt](?limit&offset){}                          /user/{user_uuid}/form/ -> 200 [{form_dto}] # List user's form submissions
GET[user_jwt](){}                                       /user/{user_uuid}/form/{form_blueprint_uuid} -> 200 {form_dto} # Get form submission
PUT[user_jwt](){form_instance}                          /user/{user_uuid}/form/{form_blueprint_uuid} -> 200 {form_dto} # Update form submission

# Project Members
GET[user_jwt](?limit&offset){}                          /user/{user_uuid}/project/{project_blueprint_uuid}/members  -> 200 [{project_members}]  # List members
POST[user_jwt](){project_members}                       /user/{user_uuid}/project/{project_blueprint_uuid}/members -> 200 {project_members}  # Add member

# FINANCES
POST[user_jwt](project_blueprint_uuid){}                            /user/{user_uuid}/project/{project_blueprint_uuid}/finances -> 200 {project_finance} # Create financial data
PUT[user_jwt](){project_finance}                                    /user/{user_uuid}/project/{project_blueprint_uuid}/finances -> 200 {project_finance} # Update financial data
GET[user_jwt](){}                                                   /user/{user_uuid}/project/{project_blueprint_uuid}/finances -> 200 {project_finance} # Get financial data
PUT[user_jwt](){project_finance}                                    /user/{user_uuid}/project/{project_blueprint_uuid}/calculate ->  200 {project_finance} # Calculate financial data
