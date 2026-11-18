
CREATE DATABASE IF NOT EXISTS campus_events;

USE campus_events;

CREATE TABLE IF NOT EXISTS registrations (
    registration_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    register_number VARCHAR(30) NOT NULL UNIQUE,
    email VARCHAR(120) NOT NULL,
    event_name VARCHAR(100) NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_event_name ON registrations(event_name);
