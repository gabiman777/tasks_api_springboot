package com.example.demo.springboot.model;

import lombok.Data;

import java.util.Date;

@Data
public class TodoTask {
    private static int idCounter = 0;

    private int id = idCounter++;
    private String title;
    private String description;

    // Its an enum that we defined
    private int status = TodoTaskStatus.NOT_STARTED;
    private Date createdAt = Date.from(java.time.Instant.now());
    private Date dueDate;

}