package com.example.demo.springboot.controller;
import com.example.demo.springboot.model.TodoTask;
import com.example.demo.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Para RestController, GetMapping, PathVariable, RequestBody, PostMapping, DeleteMapping
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController("/api")
public class TodoController {

    // Logger para esta clase
    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService; // injected our service

    @GetMapping("/tasks")
    public List<?> getAllTasks(){
        logger.debug("Fetching all tasks");
        return todoService.getAllTasks();
    }

    @GetMapping("/task/:id")
    public TodoTask getTask(@PathVariable int id){
        logger.debug("Fetching one task by id " + id);
        return todoService.getTask(id);
    }

    @DeleteMapping("/task/:id")
    public void deleteTask(@PathVariable int id){
        todoService.delete(id);
    }

    //create or update task
    @PostMapping("/task")
    public TodoTask createTask(@RequestBody TodoTask todoTask){
        return todoService.createOrUpdate(todoTask);
    }
}