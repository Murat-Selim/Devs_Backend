# Devs Project

A Spring Boot application for managing programming languages and technologies, implementing clean architecture principles with Spring Security and JWT authentication.

## Project Structure

```
Devs/
├── src/main/java/kodlamaio/Devs/
│   ├── business/
│   │   ├── abstracts/           # Service interfaces
│   │   ├── concretes/           # Service implementations
│   │   ├── requests/            # Request DTOs
│   │   │   ├── programmingLanguagesRequest/
│   │   │   ├── technologiesRequest/
│   │   │   └── authRequest/
│   │   ├── responses/           # Response DTOs
│   │   │   ├── programmingLanguagesResponse/
│   │   │   ├── technologiesResponse/
│   │   │   └── authResponse/
│   │   └── rules/               # Business validation rules
│   ├── core/
│   │   ├── exceptions/          # Global exception handling
│   │   │   └── handlers/
│   │   ├── mappers/             # MapStruct mappers
│   │   │   ├── programmingLanguageMapper/
│   │   │   ├── technologyMapper/
│   │   │   └── authMapper/
│   │   └── security/            # Security configuration
│   │       ├── config/
│   │       ├── jwt/
│   │       └── userDetails/
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
- **Spring Security** - Security framework
- **JWT (jjwt 0.11.5)** - Token-based authentication
- **PostgreSQL / H2** - Database
- **MapStruct** - Object mapping
- **Lombok** - Boilerplate reduction
- **SpringDoc OpenAPI** - API documentation
- **Validation** - Input validation

## Features

### Authentication & Authorization
- User registration with role assignment
- JWT-based login authentication
- Role-based access control (USER, ADMIN)
- Password encryption with BCrypt

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

## Spring Security Architecture

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                              CLIENT REQUEST                                  │
│                    Authorization: Bearer <jwt_token>                         │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                        JwtAuthenticationFilter                               │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ 1. Extract JWT from Authorization header                             │   │
│  │ 2. Validate token signature and expiration                          │   │
│  │ 3. Extract username from token                                       │   │
│  │ 4. Load UserDetails via UserDetailsService                          │   │
│  │ 5. Set Authentication in SecurityContextHolder                       │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                        SecurityFilterChain                                   │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • /api/auth/** → Permit All (register, login)                       │   │
│  │ • /swagger-ui/** → Permit All (documentation)                        │   │
│  │ • /h2-console/** → Permit All (H2 database console)                 │   │
│  │ • /** → Require Authentication                                      │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                           REST Controllers                                   │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ @PreAuthorize annotations for role-based access control             │   │
│  │ @Valid annotations for request validation                            │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                          Business Services                                   │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Business logic execution                                           │   │
│  │ • Business rules validation                                          │   │
│  │ • Entity-DTO mapping via MapStruct                                   │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
```

### JWT Authentication Flow

```
┌──────────────┐     POST /api/auth/register      ┌──────────────┐
│              │ ───────────────────────────────▶ │              │
│    CLIENT    │                                   │   AUTH       │
│              │ ◀─────────────────────────────── │  CONTROLLER  │
│              │     JWT Token + Success Message   │              │
└──────────────┘                                   └──────────────┘
                                                          │
                                                          ▼
┌──────────────┐                                   ┌──────────────┐
│              │     POST /api/auth/login          │              │
│    CLIENT    │ ───────────────────────────────▶ │   AUTH       │
│              │     {username, password}          │   SERVICE    │
│              │                                   │              │
│              │ ◀─────────────────────────────── │              │
│              │     JWT Token + Success Message   └──────────────┘
└──────────────┘                                          │
       │                                                  │
       │         ┌────────────────────────────────────────┘
       │         │
       ▼         ▼
┌──────────────────────────────────────────────────────────────────┐
│                        JwtService                                  │
│  ┌────────────────────────────────────────────────────────────┐  │
│  │ • generateToken(UserDetails) → JWT String                  │  │
│  │ • extractUsername(token) → String                          │  │
│  │ • isTokenValid(token, UserDetails) → boolean               │  │
│  │ • Secret: Base64 encoded key                               │  │
│  │ • Expiration: 24 hours (86400000ms)                        │  │
│  └────────────────────────────────────────────────────────────┘  │
└──────────────────────────────────────────────────────────────────┘
```

## API Documentation

Once the application is running, visit:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Configuration

Database and JWT configuration in `src/main/resources/application.properties`:

## Building the Project

```bash
cd Devs
./mvnw clean install
```

## Running the Project

```bash
./mvnw spring-boot:run
```

## API Endpoints

### Authentication
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register new user | No |
| POST | `/api/auth/login` | Login and get JWT token | No |

### Programming Languages
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/api/programmingLanguages` | Get all languages | Yes |
| GET | `/api/programmingLanguages/{id}` | Get language by ID | Yes |
| POST | `/api/programmingLanguages` | Create language | Yes |
| PUT | `/api/programmingLanguages/update` | Update language | Yes |
| DELETE | `/api/programmingLanguages/{id}` | Delete language | Yes |

### Technologies
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/api/technologies` | Get all technologies | Yes |
| GET | `/api/technologies/{id}` | Get technology by ID | Yes |
| POST | `/api/technologies` | Create technology | Yes |
| PUT | `/api/technologies` | Update technology | Yes |
| DELETE | `/api/technologies/{id}` | Delete technology | Yes |

## Business Rules

### Authentication
- Username must be unique
- Password must be at least 6 characters
- Role must be specified (USER or ADMIN)

### Programming Languages
- Name cannot be empty
- Name must be between 2 and 50 characters
- Name must be unique

### Technologies
- Name cannot be empty
- Name must be between 2 and 50 characters
- Name must be unique

## Architecture Layers

1. **Presentation Layer** - Controllers handle HTTP requests, JWT authentication filter
2. **Business Layer** - Services contain business logic, use rules for validation
3. **Data Access Layer** - Repositories interact with database
4. **Entity Layer** - Domain models
5. **Security Layer** - JWT authentication, authorization, password encryption
