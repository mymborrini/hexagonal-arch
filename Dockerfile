FROM maven:3.8.2-openjdk-17

COPY adapters/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", ".\target\app.jar"]