
# Training Center Management API

This project is a Spring Boot-based REST API for managing training centers. The API allows users to create, view, and manage training centers, including their address, courses offered, and contact information. The project uses Hibernate ORM to persist the data in a MySQL database and includes proper validation with structured error messages.

## Features

- Create a new training center with validation.
- Retrieve a list of all saved training centers.
- Validate all input fields (e.g., center name, center code, email, phone, etc.).
- Handle validation errors and return them in JSON format.

## Technologies Used

- **Java**: Programming language
- **Spring Boot**: Framework for building the API
- **Spring Data JPA**: For database interaction with Hibernate ORM
- **MySQL**: Relational database for storing training center data



## Project Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/SakshiBPatil/Backend_Traini8_SakshiPatil.git
   ```

2. **Navigate to the project directory**:

   ```bash
   cd Backend_Traini8_SakshiPatil
   ```

3. **Configure the MySQL Database**:
   
   - Create a MySQL database:
   
     ```sql
     CREATE DATABASE training_center_db;
     ```
   
   - Open the `src/main/resources/application.properties` file and configure the MySQL connection properties:

     ```properties
     # MySQL Database Configuration
     spring.datasource.url=jdbc:mysql://localhost:3306/training_center_db?useSSL=false&serverTimezone=UTC
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

     # Hibernate Configuration
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
     ```

   - Replace `your-username` and `your-password` with your MySQL credentials.

4. **Build the project**:

   Use Maven to build the project and download the dependencies:

   ```bash
   mvn clean install
   ```

5. **Run the Spring Boot application**:

   You can run the application using the following Maven command:

   ```bash
   mvn spring-boot:run
   ```

   The application will start at `http://localhost:8080`.

## API Endpoints

### 1. Create a Training Center

- **URL**: `/api/training-centers`
- **Method**: `POST`
- **Content-Type**: `application/json`
- **Description**: Creates and saves a new training center with the specified details.

#### Request Body Example:

```json
{
    "centerName": "ABC Training Center",
    "centerCode": "ABCTRN000001",
    "address": {
        "detailedAddress": "123 Street, Near ABC Mall",
        "city": "Pune",
        "state": "Maharashtra",
        "pincode": "411001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Python", "Data Science"],
    "contactEmail": "abc@trainingcenter.com",
    "contactPhone": "9876543210"
}
```

#### Response Example (Success):

```json
{
    "id": 1,
    "centerName": "ABC Training Center",
    "centerCode": "ABCTRN000001",
    "address": {
        "detailedAddress": "123 Street, Near ABC Mall",
        "city": "Pune",
        "state": "Maharashtra",
        "pincode": "411001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Python", "Data Science"],
    "createdOn": 1633024800,
    "contactEmail": "abc@trainingcenter.com",
    "contactPhone": "9876543210"
}
```

#### Response Example (Validation Errors):

```json
{
    "centerCode": "Center code must be exactly 12 alphanumeric characters",
    "contactPhone": "Phone number must be 10 digits"
}
```

### 2. Get All Training Centers

- **URL**: `/api/training-centers`
- **Method**: `GET`
- **Description**: Retrieves a list of all saved training centers. If no centers exist, an empty list will be returned.

#### Response Example:

```json
[
    {
        "id": 1,
        "centerName": "ABC Training Center",
        "centerCode": "ABCTRN000001",
        "address": {
            "detailedAddress": "123 Street, Near ABC Mall",
            "city": "Pune",
            "state": "Maharashtra",
            "pincode": "411001"
        },
        "studentCapacity": 200,
        "coursesOffered": ["Java", "Python", "Data Science"],
        "createdOn": 1633024800,
        "contactEmail": "abc@trainingcenter.com",
        "contactPhone": "9876543210"
    }
]
```

## Validations

- **Center Name**: Must not be empty and must be less than 40 characters.
- **Center Code**: Must be exactly 12 alphanumeric characters.
- **Student Capacity**: Must be a positive integer.
- **Email**: Must follow a valid email format (if provided).
- **Phone**: Must be a valid 10-digit phone number.
- **Address**: All address fields (detailed address, city, state, pincode) are required.

## Testing the API

To test the API:

1. Open **Postman** or any API testing tool.
2. Use the provided endpoints to send `POST` and `GET` requests.
3. Verify validation errors and success responses by sending both valid and invalid input data.

## Error Handling

Validation errors are handled using `@ExceptionHandler` and are returned in JSON format with detailed messages. Example validation errors are returned like:

```json
{
    "fieldName": "Error message"
}
```

## Project Structure

```
src/
│
├── main/
│   ├── java/
│   │   └── com/example/TrainingCenterProject/
│   │       ├── controller/         # API controllers
│   │       ├── entity/             # Entity classes
│   │       ├── exception/          # Exception handling
│   │       ├── repository/         # JPA repositories
│   │       └── service/            # Service layer
│   └── resources/
│       └── application.properties  # Configuration file
│
└── test/
    └── java/                       # Unit and integration tests
```
