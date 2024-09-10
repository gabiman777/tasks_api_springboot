package com.example.demo.springboot.service;

import com.example.demo.springboot.model.TodoTask;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class TodoService {

    // Our internal structure to store tasks
    private static HashMap<Integer, TodoTask> todoTaskStore = new HashMap<>();

    public TodoTask createOrUpdate(TodoTask todoTask) {
        return todoTaskStore.put(todoTask.getId(), todoTask);
    }

    public TodoTask getTask(int id) {
        return todoTaskStore.get(id);
    }

    public void delete(int id) {
        todoTaskStore.remove(id);
    }

    public List<TodoTask> getAllTasks() {
        return  todoTaskStore.values().stream().toList();
    }

}