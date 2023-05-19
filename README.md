# Project Name
Doctor App ( Hospital Management System )

# Frameworks and Language Used
**Spring Boot** 2.1.0
**Java** 20.0
**Maven** 3.8.1

# Data Flow
The following functions are used in the data flow of this project:


## Models

**Patient:**

Attributes: patientId, patientFirstName, patientLastName, patientEmail, patientPassword, patientContact.
Represents a patient in the hospital management system.
Has a one-to-one relationship with the Appointment entity.

**Doctor:**

Attributes: doctorId, doctorName, doctorExperience, doctorSpecialization, doctorContact.
Represents a doctor in the hospital management system.
Has a one-to-many relationship with the Appointment entity.
Enum Specialization represents the specialization of the doctor.

**AuthenticationToken:**

Attributes: tokenId, token, tokenCreationDate, patient.
Represents an authentication token for a patient in the hospital management system.
Has a one-to-one relationship with the Patient entity.
Generates a random unique identifier (UUID) for the token.

**AppointmentKey:**

Represents the composite key for the Appointment entity.
Attributes: appointmentId, appointmentTime.
Used as an embedded key in the Appointment entity.

**Appointment:**

Attributes: id, doctor, patient.
Represents an appointment in the hospital management system.
Uses the composite key AppointmentKey as the primary key.
Has a many-to-one relationship with the Doctor entity and a one-to-one relationship with the Patient entity.

**Specialization (Enum):**

Represents the specialization of a doctor in the hospital management system.
Possible values: NEUROLOGIST, CARDIOLOGIST, GYNECOLOGIST, DERMATOLOGIST.

## Controller


PatientController:

/signup (POST): Handles the signup process for patients. Expects a SignUpInput object in the request body and returns a SignUpOutput object.
/signin (POST): Handles the signin process for patients. Expects a SignInInput object in the request body and returns a SignInOutput object.
/doctors (GET): Retrieves a list of all doctors. Expects the userEmail and token as query parameters. Returns a ResponseEntity containing the list of Doctor objects.

DoctorController:

/doctor/add (POST): Adds a new doctor to the system. Expects a Doctor object in the request body. Returns a string indicating the result of the addition.


## Services

**AppointmentService**:

Manages the appointment-related operations.
Autowires the IAppointmentRepo repository.

**DoctorService**:

Manages the doctor-related operations.
Autowires the IDoctorRepo repository.
Provides methods to add a doctor and retrieve all doctors.


**PatientService**:

Manages the patient-related operations.
Autowires the PatientRepository, AuthenticationService, and DoctorService.
Provides methods for patient signup and signin.
Performs password encryption using MD5.
Retrieves and validates patient information.
Generates and saves authentication tokens.
Invokes the DoctorService to fetch all doctors.

**AuthenticationService**:

Manages the authentication-related operations.
Autowires the ITokenRepo repository.
Provides methods to save and retrieve authentication tokens.
Performs authentication checks based on the user's email and token.




_**Repository:**_ The repository layer is responsible for interacting with the database. It uses Spring Data JPA to perform CRUD (create, read, update, delete) operations on entities.


# Database Structure Used
I have used MySql as Database.

# Project Summary

This is an ecommerce application that allow user to place order and having differnt fetures also



