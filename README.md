# 📚 Library Management System

A RESTful Library Management System developed using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates CRUD operations, entity relationships, DTO mapping, and layered architecture following backend development best practices.

---

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Lombok
- ModelMapper
- REST APIs
- Postman (API Testing)

---

## 📂 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── config
├── exception
└── LibraryManagementApplication
```

---

## 📖 Features Implemented

### Author Management

- Create Author
- Get Author by ID
- Get All Authors
- Update Author
- Delete Author

---

### Book Management

- Create Book
- Get Book by ID
- Get All Books
- Update Book
- Delete Book

---

### Entity Relationships

Implemented the following relationship:

- One Author ➜ Many Books
- Many Books ➜ One Author

Using

- `@OneToMany`
- `@ManyToOne`
- `mappedBy`
- `CascadeType`
- `FetchType`

---

## 📦 DTO Implementation

Implemented DTOs to separate database entities from API responses.

Created

- AuthorDTO
- BookDTO

Used **ModelMapper** to convert

- Entity → DTO
- DTO → Entity

---

## 🛠 Configuration

Configured

- MySQL Database
- Spring Data JPA
- Hibernate
- ModelMapper Bean

---

## 📡 REST APIs

### Author APIs

| Method | Endpoint | Description |
|----------|----------------|----------------|
| POST | /authors | Create Author |
| GET | /authors | Get All Authors |
| GET | /authors/{id} | Get Author By ID |
| PUT | /authors/{id} | Update Author |
| DELETE | /authors/{id} | Delete Author |

---

### Book APIs

| Method | Endpoint | Description |
|----------|--------------|----------------|
| POST | /books | Create Book |
| GET | /books | Get All Books |
| GET | /books/{id} | Get Book By ID |
| PUT | /books/{id} | Update Book |
| DELETE | /books/{id} | Delete Book |

---

## 🗄 Database

Database Used:

MySQL

Main Tables

- author
- book

The **Book** table stores the foreign key of its corresponding Author.

---

## 📚 Concepts Learned

During this project I learned:

### Spring Boot

- Project structure
- Dependency Injection
- REST API development
- Bean configuration

### Spring Data JPA

- JpaRepository
- CRUD operations
- Custom queries (basic understanding)

### Hibernate

- Entity Mapping
- Persistence Context
- Entity Lifecycle
- Transactions
- Lazy vs Eager Fetching
- Cascade Operations

### JPA Relationships

- One-to-Many
- Many-to-One
- Owning Side
- Inverse Side
- mappedBy
- Foreign Keys

### DTO Pattern

- Why DTOs are needed
- Entity to DTO conversion
- DTO to Entity conversion
- ModelMapper usage

### Database

- Primary Key
- Foreign Key
- Database Normalization (basic)
- Table Relationships

### API Testing

- Using Postman
- JSON Request/Response
- HTTP Status Codes

### Maven

- Dependency Management
- Build Lifecycle

---

## 🎯 Project Objectives

- Learn Spring Boot fundamentals.
- Understand layered architecture.
- Implement CRUD operations.
- Work with relational databases.
- Practice JPA entity relationships.
- Use DTOs for clean API design.
- Build RESTful APIs following best practices.

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Run

```
LibraryManagementApplication.java
```

5. Test APIs using Postman.

---

## 📈 Future Improvements

- Pagination and Sorting
- Search Books by Title
- Search Books by ISBN
- Validation using Bean Validation
- Global Exception Handling
- Swagger/OpenAPI Documentation
- Spring Security
- JWT Authentication
- Role-Based Authorization
- Unit Testing with JUnit & Mockito
- Docker Deployment
- Logging with SLF4J
- API Documentation

---

## 👨‍💻 Author

Developed as a learning project to practice Java Backend Development using Spring Boot, Hibernate, and MySQL.
