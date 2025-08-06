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
