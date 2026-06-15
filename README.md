# Task Management System

A web-based task management application developed using Java Spring Boot, Spring Data JPA, Thymeleaf, and H2 Database.

## Features

* Create new tasks
* View all tasks
* Edit existing tasks
* Delete tasks
* Mark tasks as completed or pending
* Search tasks by title
* Filter tasks by status
* Filter tasks by priority
* Assign due dates
* Assign priority levels (LOW, MEDIUM, HIGH)
* REST API support
* H2 Database integration

---

## Technologies Used

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Thymeleaf
* H2 Database
* HTML5
* CSS3
* Maven

---

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com.example.taskmanagement
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── model
│   │       └── web
│   │
│   └── resources/
│       ├── templates
│       ├── static
│       └── application.properties
│
└── test/
```

---

## Architecture

The application follows the MVC (Model-View-Controller) architecture.

```text
Browser
   │
   ▼
Thymeleaf Views
   │
   ▼
Controllers
   │
   ▼
Services
   │
   ▼
Repositories
   │
   ▼
H2 Database
```

---

## REST API Endpoints

### Get All Tasks

```http
GET /tasks
```

### Get Task By ID

```http
GET /tasks/{id}
```

### Create Task

```http
POST /tasks
```

### Update Task

```http
PUT /tasks/{id}
```

### Delete Task

```http
DELETE /tasks/{id}
```

### Toggle Completion Status

```http
PATCH /tasks/{id}/toggle
```

---

## Running the Application

### Requirements

* Java 21
* Maven
* IntelliJ IDEA

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

or run:

```text
TaskmanagementApplication.java
```

### Open Application

```text
http://localhost:8080
```

---

## H2 Database Console

Open:

```text
http://localhost:8080/h2-console
```

Default configuration:

```text
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (empty)
```

---

## Author

Enes Emre Eravcı

University Project – Task Management System

Developed using Java Spring Boot and Thymeleaf.
