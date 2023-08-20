# crazy-task-tracker-api

Project
- id (long)
- name (string)
- createdAt (time)
- taskStates (TaskState list)

TaskState
- id (long)
- name (string)
- ordinal (long)
- createAt (time)
- tasks (Tasks list)

Task
- id (long)
- name (string)
- description (string)
- createAt (time)

- DB Entities
- DB Entity management (работа с БД)
- REST API (business logic layer)
1.45.53