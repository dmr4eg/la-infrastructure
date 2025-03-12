openapi: 3.0.3
info:
  title: Little PM – RBAC, Projects, Tasks, Reports, Video
  version: 1.0.0
  description: >
    OpenAPI specification detailing the RBAC, Projects, Tasks, Reports,
    and Video endpoints for the Little PM application.

servers:
  - url: https://app.little.pm
    description: Production Server

tags:
  - name: Project RBAC
  - name: Project Management
  - name: Tasks
  - name: Reports
  - name: Video

paths:

  #####################################################
  #               PROJECT RBAC API                    #
  #####################################################
  /rbac/{projectUUID}:
    parameters:
      - $ref: "#/components/parameters/projectUUID"
      - name: limit
        in: query
        description: Pagination limit
        required: false
        schema:
          type: integer
      - name: offset
        in: query
        description: Pagination offset
        required: false
        schema:
          type: integer
      - name: role
        in: query
        description: Filter by user role within this project (owner or member)
        required: false
        schema:
          type: string
          enum: [owner, member]

    get:
      tags:
        - Project RBAC
      summary: List project users
      description: Retrieve a list of users (and roles) within the specified project.
      operationId: getProjectRbacList
      security:
        - bearerAuth: []
      responses:
        '200':
          description: A list of RBAC records
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/RBAC'
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Project not found
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    post:
      tags:
        - Project RBAC
      summary: Create RBAC record
      description: Only the project owner can create a new RBAC record for this project.
      operationId: createProjectRbac
      security:
        - bearerAuth: []
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/RBAC'
      responses:
        '200':
          description: Successfully created an RBAC record
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/RBAC'
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '403':
          description: Only owner can create RBAC record
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'
        '404':
          description: Project not found
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    delete:
      tags:
        - Project RBAC
      summary: Remove RBAC record
      description: Only the project owner can remove an RBAC record from this project.
      operationId: deleteProjectRbac
      security:
        - bearerAuth: []
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/RBAC'
      responses:
        '200':
          description: RBAC record removed
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '403':
          description: Only owner can delete RBAC record
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'
        '404':
          description: Project or record not found
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'


  #####################################################
  #              PROJECT REST API                     #
  #####################################################
  /projects:
    get:
      tags:
        - Project Management
      summary: List all project DTOs
      description: |
        List all projects (DTO) to which the current user has read-access via RBAC.
        Supports optional pagination.
      operationId: listProjects
      security:
        - bearerAuth: []
      parameters:
        - name: limit
          in: query
          description: Pagination limit
          required: false
          schema:
            type: integer
        - name: offset
          in: query
          description: Pagination offset
          required: false
          schema:
            type: integer
      responses:
        '200':
          description: An array of project DTO
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/ProjectDTO'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: No projects found or invalid access
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    post:
      tags:
        - Project Management
      summary: Create a new project
      description: |
        Create a new project. The backend automatically generates a UUID and grants the
        creating user "owner" RBAC on success.
      operationId: createProject
      security:
        - bearerAuth: []
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/ProjectDTO'
      responses:
        '200':
          description: Project created
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/ProjectDTO'
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'

  /projects/{projectUUID}:
    parameters:
      - $ref: "#/components/parameters/projectUUID"

    get:
      tags:
        - Project Management
      summary: Retrieve a single project
      description: Retrieve a single project DTO by UUID, requires valid RBAC.
      operationId: getProject
      security:
        - bearerAuth: []
      responses:
        '200':
          description: A project DTO
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ProjectDTO'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Project not found or user lacks RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    put:
      tags:
        - Project Management
      summary: Update a project
      description: Update an existing project’s DTO, requires valid RBAC.
      operationId: updateProject
      security:
        - bearerAuth: []
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/ProjectDTO'
      responses:
        '200':
          description: Updated project DTO
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/ProjectDTO'
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Project not found or user lacks RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    delete:
      tags:
        - Project Management
      summary: Delete a project
      description: Delete a project (and its associated RBAC), requires valid RBAC.
      operationId: deleteProject
      security:
        - bearerAuth: []
      responses:
        '200':
          description: Project deleted
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Project not found or user lacks RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'


  #####################################################
  #                TASKS REST API                     #
  #####################################################
  /tasks:
    get:
      tags:
        - Tasks
      summary: List tasks accessible to the current user
      description: Retrieve a list of all tasks for which the user has valid RBAC. Supports pagination.
      operationId: listTasks
      security:
        - bearerAuth: []
      parameters:
        - name: limit
          in: query
          description: Pagination limit
          required: false
          schema:
            type: integer
        - name: offset
          in: query
          description: Pagination offset
          required: false
          schema:
            type: integer
        - name: projectUUID
          in: query
          description: If provided, filters tasks by the specified project UUID
          required: false
          schema:
            type: string
            format: uuid
      responses:
        '200':
          description: A list of tasks
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Task'
        '401':
          $ref: '#/components/responses/UnauthorizedError'

    post:
      tags:
        - Tasks
      summary: Create a new task
      description: Create a new task. The user must have valid RBAC on the project in question.
      operationId: createTask
      security:
        - bearerAuth: []
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Task'
      responses:
        '200':
          description: Task created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Task'
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Project not found or invalid RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

  /tasks/{taskUUID}:
    parameters:
      - $ref: "#/components/parameters/taskUUID"
    get:
      tags:
        - Tasks
      summary: Retrieve a single task
      description: Retrieve a task by its UUID, requires valid RBAC.
      operationId: getTask
      security:
        - bearerAuth: []
      responses:
        '200':
          description: Task retrieved
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Task'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Task not found or invalid RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    put:
      tags:
        - Tasks
      summary: Edit a task
      description: Edit a task, requires valid RBAC.
      operationId: updateTask
      security:
        - bearerAuth: []
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Task'
      responses:
        '200':
          description: Updated task
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Task'
        '400':
          $ref: '#/components/responses/BadRequest'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Task not found or invalid RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

    delete:
      tags:
        - Tasks
      summary: Delete a task
      description: Delete a task, requires valid RBAC.
      operationId: deleteTask
      security:
        - bearerAuth: []
      responses:
        '200':
          description: Task deleted
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Task'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Task not found or invalid RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'


  #####################################################
  #               REPORTS REST API                    #
  #####################################################
  /reports:
    get:
      tags:
        - Reports
      summary: List all reports accessible to the current user
      description: Retrieve a list of all reports for projects where the user has valid RBAC.
      operationId: listReports
      security:
        - bearerAuth: []
      parameters:
        - name: limit
          in: query
          description: Pagination limit
          required: false
          schema:
            type: integer
        - name: offset
          in: query
          description: Pagination offset
          required: false
          schema:
            type: integer
      responses:
        '200':
          description: A list of reports
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Report'
        '401':
          $ref: '#/components/responses/UnauthorizedError'

  /reports/{projectUUID}:
    parameters:
      - $ref: "#/components/parameters/projectUUID"
    post:
      tags:
        - Reports
      summary: Generate a new report
      description: Generate a new report for the given project. Requires valid RBAC.
      operationId: createReport
      security:
        - bearerAuth: []
      responses:
        '200':
          description: Report generated
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Report'
        '401':
          $ref: '#/components/responses/UnauthorizedError'
        '404':
          description: Project not found or user lacks RBAC
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'


  #####################################################
  #                VIDEO REST API                     #
  #####################################################
  /video/{videoUUID}:
    parameters:
      - name: videoUUID
        in: path
        required: true
        description: ID of the video
        schema:
          type: string
          format: uuid
          example: 665c599d-5c8d-4d20-aaab-7ffaba150606
    get:
      tags:
        - Video
      summary: Retrieve video object
      description: Public endpoint to retrieve a specific video object by UUID.
      operationId: getVideo
      responses:
        '200':
          description: Video found
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Video'
        '404':
          description: Video not found
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

components:
  securitySchemes:
    bearerAuth:
      description: JWT token
      type: http
      scheme: bearer
      bearerFormat: JWT

  parameters:
    projectUUID:
      name: projectUUID
      in: path
      required: true
      description: Project UUID
      schema:
        type: string
        format: uuid
        example: 665c599d-5c8d-4d20-aaab-7ffaba150606

    taskUUID:
      name: taskUUID
      in: path
      required: true
      description: Task UUID
      schema:
        type: string
        format: uuid
        example: 665c599d-5c8d-4d20-aaab-7ffaba150606

  schemas:
    # --------------------- Error Object ---------------------
    Error:
      type: object
      properties:
        message:
          type: string
          example: "An error occurred"

    # --------------------- RBAC ---------------------
    RBAC:
      type: object
      description: A record defining a user's role on a project
      properties:
        projectUUID:
          type: string
          format: uuid
          description: The project for which RBAC is assigned
        userUUID:
          type: string
          format: uuid
          description: The user to which RBAC is assigned
        role_enum:
          type: string
          enum: [owner, member]
          description: The role of this user on the project

    # --------------------- Projects ---------------------
    ProjectDTO:
      type: object
      description: Project DTO for retrieval and creation
      properties:
        projectUUID:
          type: string
          format: uuid
          description: Unique ID of the project
        userUUID:
          type: string
          format: uuid
          description: Owner/creator's user UUID
        description:
          type: string
          description: Short description of the project

    # Potentially a more detailed Project object including progress
    Project:
      type: object
      description: Full project object
      properties:
        projectUUID:
          type: string
          format: uuid
        userUUID:
          type: string
          format: uuid
        description:
          type: string
        progress:
          type: integer
          description: Percentage of project completion

    # --------------------- Tasks ---------------------
    Task:
      type: object
      description: Represents a Task
      properties:
        taskUUID:
          type: string
          format: uuid
        projectUUID:
          type: string
          format: uuid
        name:
          type: string
        status:
          type: string
          enum: [pending, completed]
        # add any other optional fields (e.g., day, notes) as needed

    # --------------------- Reports ---------------------
    Report:
      type: object
      description: A report object
      properties:
        reportUUID:
          type: string
          format: uuid
        userUUID:
          type: string
          format: uuid
        projectUUID:
          type: string
          format: uuid
        report_enum:
          type: string
          enum: [pitchDeck, marketing, financial]
        url:
          type: string
          description: URL where the generated report can be accessed

    # --------------------- Video ---------------------
    Video:
      type: object
      description: A video resource
      properties:
        videoUUID:
          type: string
          format: uuid
        title:
          type: string
        description:
          type: string
        url:
          type: string

  responses:
    BadRequest:
      description: Bad Request
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Error"

    UnauthorizedError:
      description: Unauthorized
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Error"
