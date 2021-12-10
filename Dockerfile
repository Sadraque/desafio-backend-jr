FROM openjdk:8
ADD target/desafio-backend-jr-1.0.jar desafio-backend-jr-1.0.jar
ENTRYPOINT ["java", "-jar","desafio-backend-jr-1.0.jar"]
EXPOSE 8080