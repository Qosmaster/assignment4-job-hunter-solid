# 👔 Job Hunter API

## Project Overview
This API helps desperate job seekers track their applications. It demonstrates advanced OOP principles and JDBC database interaction.
Instead of a boring library, we manage **Companies** and **Applications** (Easy Apply vs Hardcore Interview Process).

## OOP Design
* **Inheritance:** `Application` extends `BaseEntity`. `EasyApplication` and `HardcoreApplication` extend `Application`.
* **Polymorphism:** `calculateStressLevel()` works differently for instant applications vs multi-stage interviews.
* **Composition:** Each `Application` HAS-A `Company`.
* **Interfaces:** `Validatable` ensures data integrity, `Trackable` provides metrics.

## Database Schema
* **companies:** Stores employer details.
* **applications:** Stores job apps with a discriminator column `app_type`.
* **Relationships:** One-to-Many (One Company -> Many Applications).

## How to Run
1. Create PostgreSQL database `job_hunter`.
2. Run schema script from `schema.sql`.
3. Configure `DatabaseConnection.java` with your credentials.
4. Run `Main.java`.