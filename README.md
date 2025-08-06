rest-taskmanager/
│
├── src/
│   ├── main/
│   │   ├── java/com/driss/taskmanager/
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   └── TaskController.java
│   │   │   ├── config/
│   │   │   │   └── OpenApiConfig.java
│   │   │   ├── dto/
│   │   │   │   ├── AuthRequest.java
│   │   │   │   ├── TaskRequest.java
│   │   │   │   └── TaskResponse.java
│   │   │   ├── model/
│   │   │   │   ├── Task.java
│   │   │   │   └── User.java
│   │   │   ├── repository/
│   │   │   │   ├── TaskRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   ├── security/
│   │   │   │   ├── JwtFilter.java
│   │   │   │   ├── JwtUtil.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── CustomUserDetailsService.java
│   │   │   ├── service/
│   │   │   │   └── TaskService.java
│   │   │   └── RestTaskmanagerApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── application-docker.yml (optional)
│   └── test/java/com/driss/taskmanager/
│       ├── controller/
│       │   ├── AuthControllerTest.java
│       │   └── TaskControllerTest.java
│       └── service/
│           └── TaskServiceTest.java
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md  ← (we’ll write this now)
