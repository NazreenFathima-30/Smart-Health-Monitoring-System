CREATE DATABASE health_monitor;

USE health_monitor;

CREATE TABLE health_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(50),
    temperature FLOAT,
    heart_rate INT,
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
