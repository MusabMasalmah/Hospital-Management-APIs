# Hospital Management APIs

## Overview

This project provides a set of RESTful APIs for managing hospital-related data. It includes functionalities for handling doctors, patients, medications, and specializations within a hospital system.

## Features

- **Doctor Management:** Add, view, and update doctor information. Assign specializations to doctors.
- **Patient Management:** Add, view, and update patient information. Assign medications and doctors to patients.
- **Medication Management:** Add and view medications.
- **Specialization Management:** Add and view specializations.
- **Appointment Management:** Schedule, view, and update appointments.

## Technology Stack

- **Backend Framework:** Spring Boot
- **Database:** PostgreSQL
- **Dependency Management:** Maven

## Getting Started

### Prerequisites

- Java 11 or higher
- PostgreSQL
- Maven
- Git

### Setup the Database

1. Create a PostgreSQL database named `hospital_management`.
2. Configure the database connection in `src/main/resources/application.properties`.

### Build and Run

**Using Maven:**

```bash
mvn clean install
mvn spring-boot:run
```
## API Endpoints and POSTMAN Testing

### Random Postman Testing:

<details>
  <summary>Click to see testing</summary>

  ![image](https://github.com/user-attachments/assets/3ef39dff-ea9e-48d4-a3aa-72eec9d90a11)

  ![image](https://github.com/user-attachments/assets/e93316c8-405e-4336-8ca2-34f1d95d14ac)

  ![image](https://github.com/user-attachments/assets/7a166e45-c8f3-4377-b550-98a949035439)

  ![image](https://github.com/user-attachments/assets/db835ad2-15b1-46d0-87f0-4bac3f1d68db)

  ![image](https://github.com/user-attachments/assets/7d5f6e88-e4ea-4da4-ab6d-f0977fcff859)

  ![image](https://github.com/user-attachments/assets/c6ce5ed9-42a5-4ebb-bc52-74274b4b6cac)

  ![image](https://github.com/user-attachments/assets/0e2c4827-c8d2-42bc-95de-a2a519e8f444)

</details>






### Doctors:

- **GET /Doctor** - Retrieve all doctors
- **GET /Doctor/byName** - Retrieve a doctor by name
- **POST /Doctor** - Add a new doctor
- **POST /Doctor/{doctorId}/to/{specId}** - Assign a specialization to a doctor
- **PUT /Doctor/{doctorId}** - Update a doctor's details

### Patients:

- **GET /Patient** - Retrieve all patients
- **POST /Patient** - Add a new patient
- **POST /Patient/med/{medId}/to/{patId}** - Assign medication to a patient
- **POST /Patient/patient/{patId}/to/{docId}** - Assign a patient to a doctor
- **PUT /Patient/{patientId}** - Update a patient's details

### Medications:

- **GET /Med** - Retrieve all medications
- **POST /Med** - Add a new medication

### Specializations:

- **GET /Spec** - Retrieve all specializations
- **POST /Spec** - Add a new specialization
- **PUT /Spec/{specializationId}** - Update a specialization's name

### Appointments:

- **GET /Appointment** - Retrieve all appointments
- **POST /Appointment/schedule** - Schedule a new appointment
- **PUT /Appointment/{appointmentId}** - Update an existing appointment


## Annotations Explained

### @RestController
- **Description:** Indicates that the class is a RESTful controller where every method returns a domain object instead of a view. It is a combination of `@Controller` and `@ResponseBody`.

### @RequestMapping
- **Description:** Maps HTTP requests to handler methods of MVC and REST controllers.
- **Example:** `@RequestMapping(path = "/Doctor")`

### @GetMapping
- **Description:** Shortcut for `@RequestMapping(method = RequestMethod.GET)`. Used to map GET requests.
- **Example:** `@GetMapping("/byName")`

### @PostMapping
- **Description:** Shortcut for `@RequestMapping(method = RequestMethod.POST)`. Used to map POST requests.
- **Example:** `@PostMapping`

### @PathVariable
- **Description:** Indicates that a method parameter should be bound to a URI template variable.
- **Example:** `@PathVariable("doctorId") long doctorId`

### @RequestBody
- **Description:** Indicates that a method parameter should be bound to the body of the web request.
- **Example:** `@RequestBody Doctor doctor`

### @Autowired
- **Description:** Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
- **Example:** `@Autowired private DoctorService doctorService`

### @Service
- **Description:** Indicates that an annotated class is a service. This annotation serves as a specialization of `@Component`, allowing for implementation classes to be autodetected through classpath scanning.
- **Example:** `@Service`

### @Repository
- **Description:** Indicates that an annotated class is a repository, which is an abstraction of data access and storage.
- **Example:** `@Repository`

### @Query
- **Description:** Used to declare finder queries directly on repository methods. It is applied at the method level.
- **Example:** `@Query("SELECT d FROM Doctor d WHERE d.name = :name")`

### @Transactional
- **Description:** Marks a method or class as transactional. This annotation is used to manage transactions declaratively.
- **Example:** `@Transactional`

### @OneToOne
- **Description:** Defines a one-to-one relationship between two entities.
- **Example:** `@OneToOne(mappedBy = "specialization")`

### @OneToMany
- **Description:** Defines a one-to-many relationship between two entities.
- **Example:** `@OneToMany(mappedBy = "patient")`

### @ManyToMany
- **Description:** Defines a many-to-many relationship between two entities.
- **Example:** `@ManyToMany`

### @ManyToOne
- **Description:** Defines a many-to-one relationship between two entities.
- **Example:** `@ManyToOne`


## Contributing

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch
   ```
3. Commit your changes:
   ```bash
   git commit -am 'Add new feature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature-branch
   ```
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For questions or issues, please contact [musabsoos10@gmail.com](musabsoos10@gmail.com).

