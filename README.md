# Demo - Java Spring Boot

This is a demo project for Upwork's Java Spring Boot.

## Prerequisites

1. Java 17
2. Git
3. Docker

## How to Run the Project

1. clone the repository
   ```bash
   git clone https://github.com/ivanplaton/upwork-demo.git
   ```
2. open the project via IntelliJ
3. make sure Docker is running
4. run the commands in IntelliJ terminal in order:
   ```bash
   ./gradlew clean build
   docker-compose build
   docker-compose up -d
   ```
5. open browser, then go to *http://localhost:8080* or *http://localhost:8080/login*

## Credentials

| Username       | Password   |
|----------------|------------|
| the_random_guy | upworkdemo |
| user           | password   |
