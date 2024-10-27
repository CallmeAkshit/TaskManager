# **Task Tracking and Management Backend System**

This project is a backend system for a task tracking and management application designed to facilitate collaboration and organization within teams or projects. It provides features like user registration, task management, team collaboration, real-time notifications, and more.

Features Implemented So Far

1. User Management

User Registration: Users can register by providing a username, email, and password.

Endpoint: POST /api/auth/register

Passwords are hashed using BCrypt for security.

User Login: Users can log in using their credentials and receive a JWT token for authentication.

Endpoint: POST /api/auth/login

JWT is used for stateless authentication.

2. Task Management

Create a Task: Users can create a new task with a title, description, and due date. Tasks can either be independent or associated with a project.

Endpoint: POST /api/tasks

Update a Task: Users can update task details.

Endpoint: PUT /api/tasks/{taskId}

View Tasks Assigned to a User: Users can view tasks assigned to them.

Endpoint: GET /api/tasks/user/{userId}

Mark Task as Completed: Users can mark a task as completed.

Endpoint: PUT /api/tasks/{taskId}/complete

Assign a Task: Tasks can be assigned to another team member.

Endpoint: PUT /api/tasks/{taskId}/assign/{userId}

Filter and Search Tasks: Users can filter tasks by status or search tasks by title/description.

Filter Endpoint: GET /api/tasks/filter

Search Endpoint: GET /api/tasks/search

3. Project/Team Management

Create a Project: Users can create a new project to group tasks and collaborate with team members.

Endpoint: POST /api/projects

Add Users to a Project: Users can be added to a project for collaboration.

Endpoint: PUT /api/projects/{projectId}/addUser/{userId}

View Projects by User: Users can view all projects they are a part of.

Endpoint: GET /api/projects/user/{userId}

4. Comment Handling

Add Comment to a Task: Users can add comments to tasks for better collaboration.

Endpoint: POST /api/comments/task/{taskId}

View Comments for a Task: Users can view all comments associated with a specific task.

Endpoint: GET /api/comments/task/{taskId}

5. Real-Time Notifications

WebSocket Configuration: Set up WebSocket using STOMP to provide real-time notifications for task updates, new assignments, etc.

WebSocket Endpoint: /ws

Notification Integration: Notifications are triggered on specific events like task assignment, and sent to users in real-time using WebSockets.

Technologies Used

Spring Boot: For building the backend application.

Spring Security & JWT: For user authentication and authorization.

Spring Data JPA: For data persistence using an H2 database (development) with easy future migration to MySQL.

WebSocket (STOMP): For real-time notifications to users.

Maven: For dependency management.

Getting Started

Prerequisites

Java 17 or higher

Maven

Installation

Clone the repository:

git clone <repository-url>

Navigate to the project directory:

cd task-tracking-backend

Install dependencies and build the project:

mvn clean install

Run the application:

mvn spring-boot:run

Accessing the Application

H2 Console: Available at /h2-console for database inspection during development.

WebSocket Testing: Connect to the WebSocket endpoint at /ws to receive notifications.

API Documentation

The project exposes several REST endpoints for managing users, tasks, projects, comments, and notifications. You can use tools like Postman to test these endpoints.

Example Requests

Register User:

POST /api/auth/register
{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "password123"
}

Login User:

POST /api/auth/login
{
    "email": "john@example.com",
    "password": "password123"
}

Create Task:

POST /api/tasks
{
    "title": "Design UI",
    "description": "Create the initial UI for the application.",
    "dueDate": "2024-11-01"
}

Next Steps

Attachment Handling: Add the ability to attach files to tasks or comments.

Further Testing: Test all features with integration tests to ensure reliability.

Deployment: Prepare the application for deployment with a production-grade database (e.g., MySQL).

Contributing

Contributions are welcome! Feel free to open issues or create pull requests for enhancements, bug fixes, or additional features.

License

This project is licensed under the MIT License.

Contact

For any questions or suggestions, please contact Akshit Bansal.

