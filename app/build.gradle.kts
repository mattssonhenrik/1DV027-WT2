/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.5/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    id("java")
    id("application")
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Spring Boot + GraphQL
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // Bugfinder, disclosing endpoints
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    
    // Environment Variables
    implementation("io.github.cdimascio:dotenv-java:3.0.0")

    // Database
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.5")
    implementation("com.opencsv:opencsv:5.8")

    // Security (JWT)
    // implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.12.3")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.3")
    implementation("io.jsonwebtoken:jjwt-jackson:0.12.3")

    // Utility (Guava, Lombok)
    implementation("com.google.guava:guava:33.2.1-jre")
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Jakarta
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")


    // Use JUnit test framework.
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("dv027api.App")
}
