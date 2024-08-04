# Hospital Management APIs

## Overview

This project provides a set of RESTful APIs for managing hospital-related data. It includes functionalities for handling doctors, patients, medications, and specializations within a hospital system.

## Features

- **Doctor Management:** Add, view, and update doctor information. Assign specializations to doctors.
- **Patient Management:** Add, view, and update patient information. Assign medications and doctors to patients.
- **Medication Management:** Add and view medications.
- **Specialization Management:** Add and view specializations.

## Technology Stack

- **Backend Framework:** Spring Boot
- **Database:** PostgreSQL
- **Dependency Management:** Maven/Gradle

## Getting Started

### Prerequisites

- Java 11 or higher
- PostgreSQL
- Maven or Gradle
- Git

### Setup the Database

1. Create a PostgreSQL database named `hospital_management`.
2. Configure the database connection in `src/main/resources/application.properties`.

### Build and Run

**Using Maven:**

```bash
mvn clean install
mvn spring-boot:run

## API Endpoints

### Doctors:

- **GET /Doctor** - Retrieve all doctors
- **GET /Doctor/byName** - Retrieve a doctor by name
- **POST /Doctor** - Add a new doctor
- **POST /Doctor/{doctorId}/to/{specId}** - Assign a specialization to a doctor

### Patients:

- **GET /Patient** - Retrieve all patients
- **POST /Patient** - Add a new patient
- **POST /Patient/med/{medId}/to/{patId}** - Assign medication to a patient
- **POST /Patient/patient/{patId}/to/{docId}** - Assign a patient to a doctor

### Medications:

- **GET /Med** - Retrieve all medications
- **POST /Med** - Add a new medication

### Specializations:

- **GET /Spec** - Retrieve all specializations
- **POST /Spec** - Add a new specialization

## Contributing

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch
```
3. Commit your changes:


