# methods
## course service:
get [user_uuid] () - project/ - List projects with specific filters
post - project/ - Create a project from blueprint
get - project/blueprint/ - List all blueprints
get - project/{project_progressUUID} -> project_dto - Get project
put - project/{project_progressUUID} - Update project

TODO
get /project/{project_blueprint_uuid}/members -> [project_members]
post[user_uuid](project_members) /project/{project_blueprint_uuid}/members

## content service
get - project/{project_blueprint_uuid}/unit - List units
get - project/{project_blueprint_uuid}/unit/{unit_uuid} - Get unit

get - project/{project_blueprint_uuid}/unit/{unit_uuid}/task - List tasks
get - project/{project_blueprint_uuid}/unit/{unit_uuid}/form - List forms
get - project/{project_blueprint_uuid}/unit/{unit_uuid}/video - List videos

put - project/{project_blueprint_uuid}/unit/{unit_uuid}/task/{taskUUID} - Update task
put - project/{project_blueprint_uuid}/unit/{unit_uuid}/form/{formUUID} - Update form
put - project/{project_blueprint_uuid}/unit/{unit_uuid}/video/{videoUUID} - Update video

get - project/{project_blueprint_uuid}/unit/{unit_uuid}/task/{taskUUID} - Get task
put - project/{project_blueprint_uuid}/unit/{unit_uuid}/task/{taskUUID} - Update task

## finances service
get - finances/{project_blueprint_uuid} - Get finances 
post - finances/{project_blueprint_uuid} - Post finances
put - finances/{project_blueprint_uuid} - Update finances

## auth...

# scheme
project {
    blueprint: project_blueprint
    progress: project_progress
}

project_blueprint {
    project_blueprint_uuid: UUID
    title: string
    description: string
    units: [order, unit]
    difficulties: enum (easy, medium, hard)
    project_style: enum (dyi, ready_made)
    project_type: enum (course, workshop, event)
}

project_progress {
    project_blueprint_uuid: UUID
    user_uuid: UUID
    status: enum (in_progress, completed)
    date_created: date
    date_end: date
}

project_members{
    project_blueprint_uuid: UUID
    user_uuid: UUID
    member_name: string
}

# /

unit{
    blueprint: unit_blueprint
    progress: unit_progress
}

unit_blueprint{
    unit_blueprint_uuid: UUID
    title: string
    description: string
    text: string    
    media: [media]    
    tasks: [order, task]
    forms: [form]
}

unit_progress{
    unit_blueprint_uuid: UUID
    user_uuid: UUID
    media_status: boolean
    status: enum(in_progress, completed, not_started)
}

task{
    blueprint: task_blueprint
    progress: task_progress
}

task_blueprint{
    task_blueprint_uuid: UUID
    title: string
    description: string
}

task_progress{
    task_blueprint_uuid: UUID    
    user_uuid: UUID
    status: boolean
}

form{
    blueprint: form_blueprint
    progress: form_progress
}

form_blueprint{
    form_blueprint_uuid: UUID
    mandatory: boolean
    input_type: enum (text, number, file)
    title: string
    description: string
    text: string
    url: string
}

form_progress{
    form_blueprint_uuid: UUID
    user_uuid: UUID
    status: boolean
}

media{
    mediaUUID: UUID
    type: enum (video, image)
    title: string
    description: string
    text: string
}



