# Demo - Java Spring Boot
This is a demo project for upwork's java spring boot

## prerequisites
1. Git
2. Docker

## how to run the project
1. git clone https://github.com/ivanplaton/upwork-demo.git
2. open the project via intellij
3. make sure Docker is running
4. run the commands in intellij terminal in order:
   1. ./gradlew clean build
   2. docker-compose build
   3. docker-compose up -d
5. the app will crash because the tables and data are not setup yet
6. connect to the database using the following credentials:
    1. url: jdbc:postgresql://localhost:5435/upwork_demo_db
    2. username: upworkuser
    3. password: upworkpassword
7. once connected to the database, run the "init_db.sql" inside the "upwork_demo_db" and check if tables and data are created
8. run "docker-compose up -d" again via intellij terminal and wait for the application to boot up
9. open browser, then go to "localhost:8080" or "localhost:8080/login"