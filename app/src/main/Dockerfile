###############################################
# Stage 1: Build the Spring Boot application
###############################################
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy only pom.xml first for caching dependencies
COPY pom.xml .

# Download all dependencies (cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy the full project
COPY src ./src

# Package the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

###############################################
# Stage 2: Run the application
###############################################
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the packaged JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

###############################################
# Health check (recommended best practice)
###############################################
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

###############################################
# Run Spring Boot
###############################################
ENTRYPOINT ["java", "-jar", "app.jar"]
