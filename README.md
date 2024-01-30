# Employee Managment System 
This is a simple Employee Management System implemented using Spring Boot. The system provides basic CRUD (Create, Read, Update, Delete) operations for managing employee information.


### Prerequisites

Make sure you have Java and Maven installed on your machine.

### Running the Application

1. Clone the repository:

    ```bash
    git clone https://github.com/harsh8999/EmployeeManagmentSystem.git
    ```

2. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

    The application will be accessible at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Add a new employee

- **Endpoint:** `POST /employee`
- **Request Body:**
  ```json
  {
    "name": "Harsh Nayak",
    "designation": "engineer"
  }

- **Response:**
  ```json
  {
    "id": 1,
    "name": "Harsh Nayak",
    "designation": "engineer"
  }

### Get All Employees

- **Endpoint:** `GET /employee`
- **Response:**
  ```json
  [
    {
        "id": 1,
        "name": "Harsh Nayak",
        "designation": "engineer"
    }
  ]

  
### Get Employee

- **Endpoint:** `GET /employee/{id}`
- **Response:**
    ```json
    {
        "id": 1,
        "name": "Harsh Nayak",
        "designation": "engineer"
    }

### Update Employee
- **Endpoint:** `PUT /employee/{id}`
- **Request:**
    ```json
    {
        "name": "Harsh Kumar Nayak",
        "designation": "engineer"
    }

- **Response:**
    ```json
    {
        "id": 1,
        "name": "Harsh Kumar Nayak",
        "designation": "engineer"
    }

### Delete Employee
- **Endpoint:** `DELETE /employee/{id}`
- **Response:**
    ```json
    {
        "Employee with 1 deleted..."
    }


### Exception Handling
The system handles exceptions, and in case of any issues, it returns appropriate error messages with HTTP status codes.