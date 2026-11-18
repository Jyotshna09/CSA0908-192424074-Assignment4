# 3. Event Handler Pseudocode

Event handlers are methods that execute when a user interacts with GUI components. The Hospital Appointment Desk uses event listeners to process booking, searching, cancellation, and clearing operations.

### 3.1 Book Appointment Handler

```text
FUNCTION bookAppointment()

    GET patientName
    GET patientID
    GET selectedDepartment
    GET selectedDoctor
    GET appointmentDate

    IF patientName is empty OR patientID is empty
        DISPLAY "Please enter patient details"
        RETURN
    END IF

    IF department, doctor or date is not selected
        DISPLAY "Please complete appointment details"
        RETURN
    END IF

    CREATE appointment record
    SAVE appointment record
    DISPLAY "Appointment booked successfully"

END FUNCTION
```

### 3.2 Search Appointment Handler

```text
FUNCTION searchAppointment()

    GET patientID

    IF patientID is empty
        DISPLAY "Enter patient ID"
        RETURN
    END IF

    SEARCH appointment records using patientID

    IF record is found
        DISPLAY matching appointment details
    ELSE
        DISPLAY "No appointment found"
    END IF

END FUNCTION
```

### 3.3 Cancel Appointment Handler

```text
FUNCTION cancelAppointment()

    GET selected appointment

    IF no appointment is selected
        DISPLAY "Select an appointment"
        RETURN
    END IF

    ASK user for confirmation

    IF