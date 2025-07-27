# 🧑‍💼 Job Portal System

A web-based Job Portal System developed using Java, Spring Boot, Thymeleaf, and MySQL. This system allows employers to post job listings and applicants to apply, track their applications, and search for jobs efficiently.

---

## 📌 Features

### 👥 User Roles
- **Employer**: Can post jobs and view applicants.
- **Applicant**: Can search jobs, apply, and track application status.

### 🛠 Functionalities
- User registration and login with **Spring Security**
- Role-based access control (Employer / Applicant)
- Employers can:
  - Add new job listings
  - View/manage their job postings
  - View list of applicants for each job
- Applicants can:
  - Search/filter jobs by keyword/location
  - Apply for jobs
  - Track status of their applications
- Job search with real-time filtering
- Clean UI using Thymeleaf and Bootstrap

---

## 🧰 Tech Stack

| Layer       | Technology                      |
|-------------|----------------------------------|
| Frontend    | Thymeleaf, HTML, CSS, Bootstrap |
| Backend     | Java, Spring Boot               |
| Security    | Spring Security                 |
| Database    | MySQL                           |
| Build Tool  | Maven                           |
| Versioning  | Git                             |
| IDE         | IntelliJ IDEA                   |

---

## 📂 Database Schema

- **Users**: User details and roles
- **Jobs**: Job title, description, location, etc.
- **Applications**: Applicant's submissions and status

📌 SQL dump file: [`job_portal.sql`](./job_portal.sql)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/job-portal-system.git
cd job-portal-system

📌 Future Improvements
Resume upload & download support

Email notifications

Interview scheduling system

Admin panel for moderation


