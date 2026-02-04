# Job Hunter v2 (SOLID Edition)

## Project Overview
Refactored version of Job Hunter API. Now implements strict **Layered Architecture** and **SOLID Principles**.
The system manages Job Applications (Easy vs Hardcore) and Companies.

## SOLID Implementation
* **SRP (Single Responsibility):**
    * `AppRepo` only handles database SQL.
    * `AppService` handles validation and business logic.
    * `Main` only handles user input.
* **OCP (Open-Closed):**
    * We can add new application types (e.g., `InternshipApp`) without changing `AppService` logic, just by extending `Application`.
* **LSP (Liskov Substitution):**
    * `EasyApp` and `HardApp` can be used interchangeably wherever `Application` is expected.
* **ISP (Interface Segregation):**
    * `Validatable` interface is small and specific.
* **DIP (Dependency Inversion):**
    * Service layer depends on abstractions (`CrudRepository` interface), not concrete classes.

## Advanced Java Features
1. **Generics:** Used in `CrudRepository<T>` to avoid code duplication for `AppRepo` and `CompanyRepo`.
2. **Lambdas:** Used in `SortUtils` to sort applications by ID: `(a1, a2) -> a1.getId() - a2.getId()`.
3. **Reflection API:** Used in `ReflectionUtils` to inspect object structure at runtime (prints field names).
4. **Interface Default Methods:** `Validatable` has a default `printValidationStatus()` method.

## How to Run
1. Ensure PostgreSQL is running (`job_hunter` db).
2. Configure credentials in `DbHelper.java`.
3. Run `Main.java`.

## Screenshots
(Place your screenshots in the /screenshots folder)
