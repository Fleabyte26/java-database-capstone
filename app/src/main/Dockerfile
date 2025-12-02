# ================================
#   1. Build Stage (Maven)
# ================================
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (caching step)
COPY pom.xml .

RUN mvn -B -q dependency:go-offline

# Copy the application source
COPY src ./src

# Build the Spring Boot application
RUN mvn -B -q package -DskipTests


# ================================
#   2. Runtime Stage (JDK)
# ================================
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (change if your app uses different port)
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
