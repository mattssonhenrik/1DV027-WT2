FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app
COPY . /app
RUN gradle bootJar

FROM openjdk:20-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
