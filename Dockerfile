FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Student-Registration-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "app.jar"]