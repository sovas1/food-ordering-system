NOTE: If u see any RED UNDERSCORES in code please enable LOMBOK PLUGIN


Tools:

- IntelliJ IDEA
- Maven
- Lombock



Technologies/Frameworks:

- Spring Boot
- Spring Data
- H2Database
- JUnit



How to run?

- git clone url
- mvn spring-boot:run (maven need to be installed)

or

- Load folder in IDE and run ApplicationStarter



Implementation description:
- the idea was to design an extendable application for restaurant ordering system, so I decided to use Spring Boot and H2Database,
- database script (data.sql) is loaded by Spring Boot when application start,
- in script you can add your drinks/sets of lunches and thats all, program will run correctly (is extendable),
- project has a few layers,
- data is beign accessed by JpaRepository,
- dao classes provides services
- models provides entities for database
- RestaurantService is the main service, created to collect order from clients
