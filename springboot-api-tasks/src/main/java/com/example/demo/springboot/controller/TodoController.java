package com.example.demo.springboot.controller;
import com.example.demo.springboot.model.TodoTask;
import com.example.demo.springboot.service.TodoService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get all tasks",
                  notes = "No parameters required")
    @GetMapping("/tasks")
    public List<?> getAllTasks(){
        logger.debug("Fetching all tasks");
        return todoService.getAllTasks();
    }

    @ApiOperation(value = "Find a todo task based on task id",
                  notes = "Pass id to find task")
    @GetMapping("/task/:id")
    public TodoTask getTask(@PathVariable int id){
        logger.debug("Fetching one task by id " + id);
        return todoService.getTask(id);
    }

    @ApiOperation(value = "Delete the todo task based on task id",
                  notes = "Pass id to delete task")
    @DeleteMapping("/task/:id")
    public void deleteTask(@PathVariable int id){
        todoService.delete(id);
    }

    //
    @ApiOperation(value = "Create or update task",
                  notes = "Pass a json with all fields of task")
    @PostMapping("/task")
    public TodoTask createTask(@RequestBody TodoTask todoTask){
        return todoService.createOrUpdate(todoTask);
    }
}