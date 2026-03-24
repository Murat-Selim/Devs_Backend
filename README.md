# Devs Project

A Spring Boot application for managing programming languages and technologies, implementing clean architecture principles.

## Project Structure

```
Devs/
├── src/main/java/kodlamaio/Devs/
│   ├── business/
│   │   ├── abstracts/           # Service interfaces
│   │   ├── concretes/           # Service implementations
│   │   ├── requests/            # Request DTOs
│   │   │   ├── programmingLanguagesRequest/
│   │   │   └── technologiesRequest/
│   │   ├── responses/           # Response DTOs
│   │   │   ├── programmingLanguagesResponse/
│   │   │   └── technologiesResponse/
│   │   └── rules/               # Business validation rules
│   ├── core/
│   │   ├── exceptions/          # Global exception handling
│   │   └── mappers/             # MapStruct mappers
│   ├── dataAccess/              # Repository interfaces
│   │   └── abstracts/
│   ├── entities/                # Entity models
│   │   └── concretes/
│   └── webApi/
│       └── controllers/         # REST controllers
└── pom.xml
```

## Technologies Used

- **Spring Boot 2.7.5** - Backend framework
- **Spring Data JPA** - Database access
- **PostgreSQL** - Database
- **MapStruct** - Object mapping
- **Lombok** - Boilerplate reduction
- **SpringDoc OpenAPI** - API documentation
- **Validation** - Input validation

## Features

### Programming Languages Management
- Get all programming languages
- Get programming language by ID
- Add new programming language
- Update existing programming language
- Delete programming language

### Technologies Management
- Get all technologies
- Get technology by ID
- Add new technology
- Update existing technology
- Delete technology

## API Documentation

Once the application is running, visit:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Configuration

Database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/devs
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Building the Project

```bash
cd Devs
./mvnw clean install
```

## Running the Project

```bash
./mvnw spring-boot:run
```

## Business Rules

### Programming Languages
- Name cannot be empty
- Name must be unique

### Technologies
- Name cannot be empty
- Name must be unique

## Architecture Layers

1. **Presentation Layer** - Controllers handle HTTP requests
2. **Business Layer** - Services contain business logic, use rules for validation
3. **Data Access Layer** - Repositories interact with database
4. **Entity Layer** - Domain models
