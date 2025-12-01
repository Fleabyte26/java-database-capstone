MySQL Database Design

## MySQL Database Design

The relational database will store structured data such as users, appointments, prescriptions, and roles. Relationships between entities are clearly defined to ensure data integrity.

## Tables

### Users
- `user_id` INT PRIMARY KEY AUTO_INCREMENT
- `name` VARCHAR(100) NOT NULL
- `email` VARCHAR(100) UNIQUE NOT NULL
- `password` VARCHAR(255) NOT NULL
- `role` ENUM('Admin','Doctor','Patient') NOT NULL
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Doctors
- `doctor_id` INT PRIMARY KEY AUTO_INCREMENT
- `user_id` INT NOT NULL (FK to Users)
- `specialization` VARCHAR(100)
- `contact_number` VARCHAR(20)
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Patients
- `patient_id` INT PRIMARY KEY AUTO_INCREMENT
- `user_id` INT NOT NULL (FK to Users)
- `date_of_birth` DATE
- `gender` ENUM('Male','Female','Other')
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Appointments
- `appointment_id` INT PRIMARY KEY AUTO_INCREMENT
- `patient_id` INT NOT NULL (FK to Patients)
- `doctor_id` INT NOT NULL (FK to Doctors)
- `appointment_time` DATETIME NOT NULL
- `status` ENUM('Scheduled','Completed','Canceled') DEFAULT 'Scheduled'
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Prescriptions
- `prescription_id` INT PRIMARY KEY AUTO_INCREMENT
- `appointment_id` INT NOT NULL (FK to Appointments)
- `medications` TEXT
- `instructions` TEXT
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### DoctorAvailability
- `availability_id` INT PRIMARY KEY AUTO_INCREMENT
- `doctor_id` INT NOT NULL (FK to Doctors)
- `available_date` DATE NOT NULL
- `start_time` TIME NOT NULL
- `end_time` TIME NOT NULL

---

# MongoDB Collection Design

The document-based database will store flexible data such as notes, chat messages, or uploaded documents. Collections allow embedded or nested structures for easier retrieval.

## Collections

### Notes
```json
{
  "_id": ObjectId,
  "patient_id": ObjectId,
  "doctor_id": ObjectId,
  "appointment_id": ObjectId,
  "note_text": "Patient shows improvement in mobility",
  "created_at": ISODate
}
### Collection: chatMessages
```json
{
  "_id": "ObjectId('64def123456')",
  "fromUserId": "ObjectId('64abc987654')",
  "toUserId": "ObjectId('64abc654321')",
  "messageText": "Hello, your appointment is confirmed for tomorrow at 10 AM.",
  "sentAt": "2025-11-30T08:30:00Z",
  "read": false,
  "attachments": [
    {
      "filename": "prep_instructions.pdf",
      "fileType": "application/pdf",
      "uploadedAt": "2025-11-29T12:15:00Z"
    }
  ],
  "tags": ["appointment", "reminder", "patient"]
}
