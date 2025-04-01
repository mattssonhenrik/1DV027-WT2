FROM openjdk:20-jdk-slim

WORKDIR /app

COPY .env .env
COPY build/libs/app.jar app.jar

CMD ["java", "-jar", "app.jar"]
