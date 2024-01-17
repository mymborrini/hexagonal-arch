FROM maven:3.8.2-openjdk-17

COPY adapters/target/*.jar .

ENTRYPOINT ["java", "-jar", ".\target\adapters-0.0.1-SNAPSHOT.jar"]