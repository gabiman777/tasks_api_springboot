# Project: tasks_api_springboot

# Goal
Make a Restful API using Java spring boot

# Technology
Java JDK 21
Maven
Springboot
Lombok

# How to run
Go to root folder:
cd springboot-api-tasks

Execute this command:
mvn spring-boot:run

#How to test

1. Open Postman

2. Create request type POST:
http://localhost:8080/task
with body type json, like this:
{
    "title": "Task 3",
    "description": "This is third sample task"
}

3. Create request type GET:
http://localhost:8080/tasks
without body

You can follow images in Screenshots folder to make requests (steps 2 and 3)