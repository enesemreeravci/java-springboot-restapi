package com.example.taskmanagement.web;

import com.example.taskmanagement.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.taskmanagement.model.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final TaskService service;

    public HomeController(TaskService service)
    {
        this.service = service;
    }

    @GetMapping("/")
    public  String printIndex(Model model)
    {
        model.addAttribute("tasks", service.getAllTasks());
        return "index";
    }

    @PostMapping("/tasks/create")
    public String createTask(Task task)
    {
        service.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id)
    {
        service.deleteTask(id);

        return "redirect:/";
    }

    @PostMapping("/tasks/toggle/{id}")
    public String toggleTask(@PathVariable Long id)
    {
        service.toggleCompleted(id);
        return "redirect:/";
    }

}
