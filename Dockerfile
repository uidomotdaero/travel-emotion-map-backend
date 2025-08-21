FROM maven:3.8.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 빌드 결과물을 실행할 JDK 이미지
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/uidomotdaero-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8080