# 📝 Task Manager REST API (Spring Boot + JWT + Docker)

A secure task management REST API built with Spring Boot 3, JWT authentication, PostgreSQL, Docker, and Swagger. Designed for clean code, portability, and DevOps deployment — ideal for full-stack integration or microservices.

---

## 📌 Features

✅ User Registration & Login  
✅ JWT Authentication (Stateless)  
✅ Task CRUD for Authenticated Users  
✅ Swagger UI for Documentation  
✅ PostgreSQL Integration  
✅ Dockerized Environment  
✅ Unit & Integration Testing with JUnit & Mockito  

---

## 🚀 Technologies Used

- **Java 17**, **Spring Boot 3**
- **Spring Security**, **JWT**
- **PostgreSQL**, **Spring Data JPA**
- **Docker** & **Docker Compose**
- **Swagger / OpenAPI**
- **JUnit 5**, **Mockito**

---

## 🛠️ Running Locally

### 🔧 Requirements

- Java 17+
- Maven
- Docker (for containerized setup)

---

### ✅ Option 1: Run with Docker (recommended)

```bash
# Build and run all services
docker-compose up --build
API: http://localhost:8080
Swagger: http://localhost:8080/swagger-ui/index.html

POST /api/auth/register
{
  "email": "test@example.com",
  "password": "123456"
}
