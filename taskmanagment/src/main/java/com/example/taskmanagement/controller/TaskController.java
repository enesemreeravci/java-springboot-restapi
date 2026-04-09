package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    // controller stores a reference to the service
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
    // connects the method to the url
    // http://localhost:8080/tasks
    @GetMapping("/tasks")
    public List<Task> all() {
        return service.getAllTasks();
        // controller does not fetch from database itself
        // it asks the service
    }


    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task)
    {
        return service.saveTask(task);
    }
}