# Build stage
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Health check using Actuator
HEALTHCHECK --interval=30s --timeout=5s \
    CMD wget -q -O- http://localhost:8080/actuator/health | grep -q 'UP' || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]