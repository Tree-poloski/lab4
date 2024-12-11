FROM openjdk:17-alpine
WORKDIR /app
COPY spring_docker.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
