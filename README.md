# Project Title
Clearly state the name of your API project.

# Implementation type
GraphQL

# Links 
- [[Production url](https://cscloud6-219.lnu.se/graphiql/?path=/api/graphql)]
- [[Dccumentation url](https://documenter.getpostman.com/view/33400340/2sB2cSi4Mj)]

## Description
This is a full-stack GraphQL API built with Java and Spring Boot, designed to manage a large collection of books.  
It supports queries and mutations for retrieving and modifying book and user data, including JWT-authenticated user registration and login.  
The backend is connected to a PostgreSQL database and uses Spring Data JPA for data access.

Main features:

- GraphQL endpoint for flexible querying and mutations
- JWT-based authentication system
- Book lookup by ISBN, including title, author, and rating
- Ability to seed the database from CSV
- Postman tests using Newman
- Dockerized PostgreSQL for easy testing and deployment
- CI/CD integration via GitLab pipeline
- NGINX reverse proxy for production deployment

## Technologies Used
| Category              | Technologies                                                   |
|-----------------------|----------------------------------------------------------------|
| Language & Frameworks | Java, Spring Boot                                              |
| API                   | GraphQL                                                        |
| Authentication        | JWT (JSON Web Tokens)                                          |
| Database              | PostgreSQL, Spring Data JPA                                    |
| Testing               | Postman, Newman                                                |
| Configuration         | `.env` environment variables                                   |
| Containers            | Docker, Docker Compose                                         |
| CI/CD                 | GitLab CI/CD                                                   |
| Deployment            | NGINX reverse proxy                                            |

# Installation Instructions

## Prerequisites

Before you begin, make sure the following are installed on your system:

- [Java 17+](https://adoptium.net/)
- [Gradle 8.5+](https://gradle.org/install/)
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Node.js + npm](https://nodejs.org/) (needed for Newman)

---

## Clone the Project

```bash
git clone git@gitlab.lnu.se:1dv027/student/hm222yj/assignment-api-design.git
cd assignment-api-design/app
```

---

## Create an `.env` File

```bash
touch .env
```

Paste the following content into `.env`:

```env
DB_URL=jdbc:postgresql://localhost:5432/books_database
DB_USER=postgres
DB_PASSWORD=lassokastning
JWT_SECRET=C3UE0DCjvlu1Do0T/yeEJPEMgIplHVlacNtxCh5bqxk=
```

---

## Start the Database with Docker

```bash
docker compose up -d db
```

This runs only the PostgreSQL service locally.

---

## Install Newman and Run the Tests

```bash
sudo npm install -g newman
newman run 1dv027-API.postman_collection.json --environment 1dv027-API.postman_environment.json
```
