FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/uidomotdaero-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8080