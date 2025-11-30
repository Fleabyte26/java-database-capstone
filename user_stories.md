# User Story Template
**Title:**
_As a [user role], I want [feature/goal], so that [reason]._  
**Acceptance Criteria:**
1. [Criteria 1]
2. [Criteria 2]
3. [Criteria 3]
**Priority:** [High/Medium/Low]
**Story Points:** [Estimated Effort in Points]
**Notes:**
- [Additional information or edge cases]

# Admin User Stories

## Admin Login
**Title:** Admin Login  
_As an admin, I want to log into the portal with my username and password, so that I can manage the platform securely._  
**Acceptance Criteria:**
1. Admin can enter username and password.
2. Admin is authenticated against the system.
3. Successful login redirects to the dashboard.
**Priority:** High  
**Story Points:** 3  
**Notes:** Consider lockout after multiple failed attempts.

## Admin Logout
**Title:** Admin Logout  
_As an admin, I want to log out of the portal, so that I can protect system access._  
**Acceptance Criteria:**
1. Logout button is visible on all pages.
2. Clicking logout ends the session.
3. Redirects to the login page after logout.
**Priority:** High  
**Story Points:** 2  
**Notes:** Ensure session tokens are invalidated.

## Add Doctor
**Title:** Add Doctor  
_As an admin, I want to add doctors to the portal, so that new staff can manage patients and appointments._  
**Acceptance Criteria:**
1. Admin can enter doctor details (name, specialty, contact).
2. Validation checks for required fields.
3. Doctor is added to the database and appears on the dashboard.
**Priority:** High  
**Story Points:** 3  
**Notes:** Handle duplicate entries gracefully.

## Delete Doctor
**Title:** Delete Doctor  
_As an admin, I want to delete a doctor’s profile, so that inactive or removed staff are no longer in the system._  
**Acceptance Criteria:**
1. Admin can select a doctor to delete.
2. Confirmation dialog appears before deletion.
3. Doctor is removed from the database and dashboard updates.
**Priority:** Medium  
**Story Points:** 2  
**Notes:** Ensure related appointments are handled (archived or reassigned).

## Run Appointment Report Stored Procedure
**Title:** Run Appointment Report Stored Procedure  
_As an admin, I want to run a stored procedure in MySQL CLI to get the number of appointments per month, so that I can track platform usage statistics._  
**Acceptance Criteria:**
1. Admin can execute the stored procedure from the portal or CLI.
2. Monthly appointment counts are returned per doctor.
3. Data can be exported or displayed in a table/chart.
**Priority:** Medium  
**Story Points:** 3  
**Notes:** Ensure SQL injection prevention and proper permissions.

## Assign Roles
**Title:** Assign Roles  
_As an admin, I want to assign roles to users, so that each user has the correct permissions in the portal._  
**Acceptance Criteria:**
1. Admin can select a user and assign a role.
2. Role assignment is saved to the database.
3. Access control updates immediately based on role.
**Priority:** Medium  
**Story Points:** 2  
**Notes:** Validate role changes for existing sessions.

## View System Usage Logs
**Title:** View System Usage Logs  
_As an admin, I want to view system usage logs, so that I can monitor activity and detect anomalies._  
**Acceptance Criteria:**
1. Admin can access logs from the dashboard.
2. Logs include user actions and timestamps.
3. Logs can be filtered by user, date, or action type.
**Priority:** Medium  
**Story Points:** 3  
**Notes:** Ensure sensitive data is masked.

# Patient User Stories

## View Doctors Without Logging In
**Title:** View List of Doctors  
_As a patient, I want to view a list of doctors without logging in, so that I can explore options before registering._  
**Acceptance Criteria:**  
1. Patients can access the doctor list page without authentication.  
2. Doctor information such as name and specialty is displayed.  
3. Option to register or log in is provided.  
**Priority:** Medium  
**Story Points:** 2  
**Notes:** Data is read-only; no booking allowed before login.  

## Patient Sign-Up
**Title:** Patient Sign-Up  
_As a patient, I want to sign up using my email and password, so that I can book appointments._  
**Acceptance Criteria:**  
1. Registration form accepts email, password, and required details.  
2. Validation for email format and password strength is enforced.  
3. Successful registration allows login and booking.  
**Priority:** High  
**Story Points:** 3  
**Notes:** Prevent duplicate accounts with the same email.  

## Patient Login
**Title:** Patient Login  
_As a patient, I want to log into the portal, so that I can manage my bookings._  
**Acceptance Criteria:**  
1. Login form accepts email and password.  
2. Correct credentials allow access to the dashboard.  
3. Invalid credentials display an error message.  
**Priority:** High  
**Story Points:** 2  
**Notes:** Implement session management for security.  

## Patient Logout
**Title:** Patient Logout  
_As a patient, I want to log out of the portal, so that I can secure my account._  
**Acceptance Criteria:**  
1. Logout option is visible on all pages.  
2. Clicking logout ends the session and redirects to the login page.  
3. LocalStorage and session tokens are cleared.  
**Priority:** High  
**Story Points:** 1  
**Notes:** Ensure token invalidation on the server side.  

## Book Appointment
**Title:** Book Appointment  
_As a patient, I want to book an hour-long appointment, so that I can consult with a doctor._  
**Acceptance Criteria:**  
1. Patient can select a doctor and available time slot.  
2. Appointment duration is set to one hour.  
3. Booking is saved in the database and confirmation is shown.  
**Priority:** High  
**Story Points:** 3  
**Notes:** Prevent double-booking for the same slot.  

## View Upcoming Appointments
**Title:** View Upcoming Appointments  
_As a patient, I want to view my upcoming appointments, so that I can prepare accordingly._  
**Acceptance Criteria:**  
1. Dashboard shows all future appointments.  
2. Appointment details include doctor name, date, and time.  
3. Past appointments are not displayed in this section.  
**Priority:** Medium  
**Story Points:** 2  
**Notes:** Optional reminder notifications could be added later.  

# Doctor User Stories

## Doctor Login
**Title:** Doctor Login  
_As a doctor, I want to log into the portal, so that I can manage my appointments._  
**Acceptance Criteria:**  
1. Login form accepts email/username and password.  
2. Correct credentials allow access to the doctor dashboard.  
3. Invalid credentials show an error message.  
**Priority:** High  
**Story Points:** 2  
**Notes:** Session management should prevent unauthorized access.

## Doctor Logout
**Title:** Doctor Logout  
_As a doctor, I want to log out of the portal, so that I can protect my data._  
**Acceptance Criteria:**  
1. Logout button is visible on all pages.  
2. Clicking logout ends the session and redirects to the login page.  
3. LocalStorage/session tokens are cleared.  
**Priority:** High  
**Story Points:** 1  
**Notes:** Ensure server-side session invalidation.

## View Appointment Calendar
**Title:** View Appointment Calendar  
_As a doctor, I want to view my appointment calendar, so that I can stay organized._  
**Acceptance Criteria:**  
1. Calendar displays all upcoming appointments.  
2. Each appointment shows patient name, time, and type.  
3. Past appointments are visually distinguishable from future ones.  
**Priority:** Medium  
**Story Points:** 3  
**Notes:** Consider weekly/monthly views for better usability.

## Mark Unavailability
**Title:** Mark Unavailability  
_As a doctor, I want to mark my unavailability, so that patients see only available slots._  
**Acceptance Criteria:**  
1. Doctor can select time slots to mark as unavailable.  
2. Unavailable slots are not bookable by patients.  
3. Changes are saved and reflected in real-time on patient booking pages.  
**Priority:** Medium  
**Story Points:** 3  
**Notes:** Consider recurring unavailability patterns (e.g., weekly off).

## Update Profile
**Title:** Update Profile  
_As a doctor, I want to update my profile with specialization and contact information, so that patients have up-to-date information._  
**Acceptance Criteria:**  
1. Doctor can edit fields like name, specialty, email, phone, and consultation hours.  
2. Changes are validated and saved to the database.  
3. Updated info is displayed to patients in the portal.  
**Priority:** Medium  
**Story Points:** 2  
**Notes:** Validate email and phone number formats.

## View Patient Details
**Title:** View Patient Details  
_As a doctor, I want to view patient details for upcoming appointments, so that I can be prepared._  
**Acceptance Criteria:**  
1. Doctor can see patient name, age, contact info, and medical history.  
2. Patient info is read-only.  
3. Access is only for patients with upcoming appointments.  
**Priority:** High  
**Story Points:** 2  
**Notes:** Ensure sensitive data is protected with role-based access.

## Receive Appointment Notifications
**Title:** Receive Appointment Notifications  
_As a doctor, I want to receive notifications for new bookings or cancellations, so that I can stay updated._  
**Acceptance Criteria:**  
1. Doctor receives a notification on the dashboard when a booking is made or canceled.  
2. Notifications include patient name and appointment time.  
3. Notification history can be reviewed.  
**Priority:** Medium  
**Story Points:** 2  
**Notes:** Optional email or SMS notifications can be added later.
