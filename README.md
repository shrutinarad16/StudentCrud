# 📚 Student Management REST API (Spring Boot)

A **Spring Boot REST API** for managing student records with full **CRUD** functionality, built using **MVC architecture**, **best coding practices**, and integrated with **Spring Security**, **Lombok**, **Log4j2 logging**, and **global exception handling**.

---

## 🚀 Features
- Create, Read, Update, Delete (**CRUD**) student records
- **MVC Pattern** (Controller → Service → Repository)
- **REST API best practices** (clean URIs, proper HTTP methods, status codes)
- **Spring Security** (Basic Authentication)
- **Lombok** for boilerplate code reduction
- **Log4j2** for structured logging
- **Global Exception Handling** with custom exception classes
- Easy integration with **Postman** for testing

---

## 🏗 Project Structure
src/main/java/com/example/studentapi
│
├── controller
│ └── StudentController.java # Handles HTTP requests
│
├── service
│ └── StudentService.java # Business logic
│ └── impl
│ └── StudentServiceImpl.java
│
├── repository
│ └── StudentRepository.java # Data access layer
│
├── entity
│ └── Student.java # Student model/entity
│
├── exception
│ ├── StudentNotFoundException.java
│ └── GlobalExceptionHandler.java
│
├── config
│ ├── SecurityConfig.java # Spring Security setup
│ └── LoggingConfig.java # Log4j2 configuration (optional)
│
└── StudentApiApplication.java # Main application class

---
## 📋 API Endpoints

| Method | URI                 | Description                      | Request Body Example |
|--------|---------------------|----------------------------------|----------------------|
| POST   | `/student`          | Add a new student                | `{ "rollNo": 101, "name": "Shruti Narad", "percentage": 92.5, "branch": "CSE" }` |
| PUT    | `/student/{id}`     | Update existing student by ID    | `{ "rollNo": 101, "name": "Updated Name", "percentage": 95.0, "branch": "IT" }` |
| GET    | `/student/{id}`     | Fetch student by ID              | N/A |
| GET    | `/students`         | Fetch all students               | N/A |
| DELETE | `/student/{id}`     | Delete student by ID             | N/A |

---

## 🛠 Technologies Used
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **Spring Security**
- **Lombok**
- **Log4j2**
- **H2/MySQL Database**
- **Maven**

---

## 🧩 Best Practices Followed
1. **Clean URI design**:
   - Nouns, not verbs → `/student`, `/students`
   - Use plural for collections, singular for specific resources
2. **Proper HTTP status codes**:
   - `201 Created` for POST
   - `200 OK` for GET & PUT
   - `204 No Content` for DELETE
3. **Layered MVC architecture**:
   - Controller → Service → Repository
4. **Consistent naming convention**:
   - Classes → `PascalCase`
   - Methods & variables → `camelCase`
5. **Logging**:
   - Log at appropriate levels (`INFO`, `ERROR`, `DEBUG`)
6. **Security**:
   - Basic Authentication for API access
7. **Exception handling**:
   - Custom exception classes (`StudentNotFoundException`)
   - Centralized error handling (`GlobalExceptionHandler`)

---

## 🖊 Sample JSON for Testing

### ✅ Add Student (POST `/student`)
```json
{
  "rollNo": 101,
  "name": "Shruti Narad",
  "percentage": 92.5,
  "branch": "Computer Science"
}
```

### ✅ Update Student (PUT /student/{id})
```json
{
  "rollNo": 101,
  "name": "Shruti Updated",
  "percentage": 95.0,
  "branch": "AI & ML"
}
```
### ✅ Example of Invalid JSON (for testing validations)

```json
{
  "rollNo": -1,
  "name": "",
  "percentage": 200,
  "branch": ""
}
```

##🔐 Authentication
Spring Security is enabled with Basic Authentication.

Default credentials (can be changed in application.properties):

Username: admin

Password: admin123

Use Postman Authorization → Basic Auth to provide credentials.

## 📜 Logging (Log4j2)
Logs stored in logs/application.log

Example log entry:
```pgsql
2025-08-08 14:35:27 INFO  StudentController - Fetching student with ID: 101
```

