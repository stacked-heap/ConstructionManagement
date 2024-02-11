FROM openjdk:18
WORKDIR /app
COPY ./target/ConstructionManagement-1.0.2.jar /app
EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=prod", "-jar", "ConstructionManagement-1.0.2.jar"]