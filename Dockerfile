FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY build/libs/upwork-demo-0.0.1-SNAPSHOT.jar /app/upwork-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/upwork-demo.jar"]
