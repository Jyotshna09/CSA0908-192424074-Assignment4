# Task 2 – Hospital Appointment Desk
## 1. Event Table

An event-driven system responds to user actions such as button clicks, text entry, and selection changes. In a Hospital Appointment Desk application, events are used to book appointments, search doctors, validate patient details, and cancel bookings.

| GUI Component | Event | Event Handler | Action Performed |
|---|---|---|---|
| Patient Name Field | Text Input | KeyListener / DocumentListener | Accepts patient name |
| Patient ID Field | Text Input | DocumentListener | Accepts patient ID |
| Department Combo Box | Item Selection | ItemListener | Updates available doctors |
| Doctor Combo Box | Item Selection | ItemListener | Selects a doctor |
| Date Picker | Date Selection | ActionListener | Selects appointment date |
| Book Appointment Button | Button Click | ActionListener | Validates details and books appointment |
| Search Button | Button Click | ActionListener | Searches existing appointments |
| Cancel Button | Button Click | ActionListener | Cancels selected appointment |
| Clear Button | Button Click | ActionListener | Clears all input fields |

### Explanation

Each GUI component generates events when the user interacts with it. Event listeners detect these events and call the appropriate handler methods.

For example, when the user clicks the Book Appointment button, an ActionEvent is generated. The ActionListener receives the event and calls the booking method. The application validates the entered details before confirming the appointment.

This approach separates user interaction from application logic and makes the system easier to maintain.