
# Task 6 – Campus Event Registration Desktop Application

## Objective
To develop a desktop-based campus event registration system using Java Swing.

## Technologies Used
- Java
- Java Swing
- AWT
- Collections Framework
- SwingWorker

## Features
1. Student registration form.
2. Input validation.
3. Duplicate register number prevention.
4. Event selection and filtering.
5. JTable registration display.
6. Previous and Next pagination.
7. CSV export.
8. Background table loading using SwingWorker.

## Execution

Compile:
javac -d out src/ui/EventRegistrationApp.java

Run:
java -cp out ui.EventRegistrationApp

## Storage
Registration data is maintained in memory during application execution. Data is reset when the application closes.

## Conclusion
The application demonstrates event-driven GUI programming, input validation, event filtering, pagination, background processing, and CSV file export.
