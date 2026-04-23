FROM openjdk:25-ea-21-jdk-slim
WORKDIR /app
COPY build/libs/frontend.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]