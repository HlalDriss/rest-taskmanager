# Stage 1: Build the WAR file using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests --batch-mode

# Stage 2: Deploy WAR to Tomcat
FROM tomcat:10.1-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=builder /app/target/rest-taskmanager-*.war /usr/local/tomcat/webapps/rest-taskmanager.war
EXPOSE 8080
CMD ["catalina.sh", "run"]