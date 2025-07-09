## Project Description

Backend Application to manage a Job Search Site. 

### Changes TODO

### Entity Layer

* **`@Data` Annotation**: The `@Data` annotation should not be used on entities. [cite_start]It automatically generates `equals` and `hashCode` methods, which can lead to issues; these methods should be implemented manually.
* **Single Responsibility Principle (SRP)**: The entity layer violates the Single Responsibility Principle as it contains validation annotations. These validations must be moved to the DTOs.
* **Database Constraints vs. Application Validations**: Do not confuse database attribute constraints (e.g., `columnDefinition` property) with application-level validations (e.g., Hibernate validations).
* **DTO Usage**: It is crucial to use DTOs. A recommended package structure for these would be `model` (containing `response`, `request`, `mapper` sub-packages).
* **Lombok Usage**: If Lombok is already a dependency, utilize it for getters and setters.
* **Date Annotations**: Review annotations like `@Temporal` (for Java versions prior to 8), `@CreationTimestamp`, `@UpdateTimestamp`, `@CreateDate`, and `@LastModifiedDate`.

### Repository Layer

* **Language Consistency**: Reiterate consistency in language: project level in English, database in Spanish (tables, attributes, etc.).
* **Use Case Specificity**: Implement according to the specific use case.

### Service Layer

* **Dependency Injection**: Use constructor injection exclusively for dependencies.
* **Abstract User Logic**: If `User` is not intended to be instantiated directly (i.e., it's abstract), work the logic on its child classes to prevent over-engineering with generics. Be prepared to explain the rationale behind your current approach.
* **Transactional Properties**: For `@Transactional` annotations, use the `readOnly=true` property where appropriate.

### Controller Layer

* **Avoid Over-engineering**: Avoid over-engineering, such as `UserController<T extends Usuario>`.
* **Validation Scope**: Validations should **only** be at the DTO level.
* **`@Validated` Annotation**: When performing DTO validations, review the `@Validated` annotation to ensure Spring applies your constraints.

### General Tips

* **Configuration Package**: Consider placing your configuration classes in a dedicated `config` package.