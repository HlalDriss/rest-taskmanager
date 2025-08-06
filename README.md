# Task Manager API

A robust Spring Boot RESTful API for managing tasks, featuring JWT authentication, OpenAPI documentation, and Dockerized deployment with PostgreSQL support.

---

## Table of Contents

- [Project Goals](#project-goals)
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Configuration](#configuration)
  - [Environment Variables](#environment-variables)
  - [Running with Docker Compose (Local PostgreSQL)](#running-with-docker-compose-local-postgresql)
  - [Running with Docker Compose (Remote PostgreSQL)](#running-with-docker-compose-remote-postgresql)
  - [Running Locally (Without Docker)](#running-locally-without-docker)
- [API Documentation](#api-documentation)
- [Security](#security)
- [License](#license)

---

## Project Goals

- Provide a secure, scalable REST API for task management.
- Enable easy integration and documentation via OpenAPI (Swagger).
- Support containerized deployment for local and production environments.

## Features

- CRUD operations for tasks
- JWT-based authentication and authorization
- Grouped API endpoints under `/api/**`
- OpenAPI 3.0 documentation (Swagger UI)
- Dockerized deployment with PostgreSQL support

## Project Structure
```
rest-taskmanager/
├── docker-compose-local.yml         # Docker Compose for local PostgreSQL
├── docker-compose.yml               # Docker Compose for remote PostgreSQL
├── Dockerfile                       # Dockerfile for building the app image
├── pom.xml                          # Maven build file
├── src/
│   ├── main/
│   │   ├── java/com/dhlal/
│   │   │   └── resttaskmanager/
│   │   │       ├── config/          # Configuration classes (OpenAPI, Security, etc.)
│   │   │       ├── controller/      # REST controllers
│   │   │       ├── model/           # Entity and DTO classes
│   │   │       ├── repository/      # Spring Data JPA repositories
│   │   │       ├── service/         # Business logic
│   │   │       └── ResttaskmanagerApplication.java  # Main entry point
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application.yml
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/com/dhlal/
└── target/                          # Build output
```
## Technologies Used

- Java 17+
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Maven
- OpenAPI (Swagger via springdoc-openapi)
- Docker & Docker Compose

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- Docker & Docker Compose

### Configuration

Edit `src/main/resources/application.yml` or `application.properties` to set database and JWT properties as needed.
### Environment Variables

Before running with Docker Compose, create a `.env` file in the project root. This file should contain your database and application configuration. Example:

```dotenv
DB_HOST=your_postgres_host
DB_NAME=your_database_name
DB_USERNAME=your_database_user
DB_PASSWORD=your_database_password
SPRING_PROFILES_ACTIVE=dev
SERVER_PORT=8080
```
### Running with Docker Compose (Local PostgreSQL)

This will start both the API and a local PostgreSQL instance.

```bash
docker-compose -f docker-compose-local.yml up --build
```
- API: http://localhost:8080
- PostgreSQL: localhost:5432 (default user/password as set in the compose file)

### Running with Docker Compose (Remote PostgreSQL)
If you have a remote PostgreSQL instance, configure its credentials in docker-compose.yml and run:
```bash
docker-compose up --build
```
### Running Locally (Without Docker)
 Start your PostgreSQL server and update DB credentials in application.yml or application.properties.
- Build and run the app:
```bash
mvn clean install
mvn spring-boot:run
```
### API Documentation
 Swagger UI is available at:

- http://localhost:8080/swagger-ui.html
- or http://localhost:8080/swagger-ui/index.html
### Security
 All /api/** endpoints are secured with JWT. Add the following header to your requests:
 ```bash
Authorization: Bearer <your-jwt-token>
```
### License
 This project is licensed under the MIT License.
```bash
Replace `<your-jwt-token>` with a valid token when making requests. Update the license section as appropriate for your project.
```
