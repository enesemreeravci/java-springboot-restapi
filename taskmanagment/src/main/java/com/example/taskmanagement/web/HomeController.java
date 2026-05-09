package com.example.taskmanagement.web;

import com.example.taskmanagement.service.TaskService;
import org.springframework.boot.Banner;
import org.springframework.data.convert.JMoleculesConverters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.taskmanagement.model.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final TaskService service;

    public HomeController(TaskService service)
    {
        this.service = service;
    }

    @GetMapping("/")
    public String printIndex(@RequestParam(required = false) String keyword, Model model)
    {
        model.addAttribute("tasks", service.searchTasks(keyword));
        model.addAttribute("keyword", keyword);
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

    @GetMapping("/tasks/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model)
    {
        Task task = service.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        model.addAttribute("task", task);

        return "edit-task";
    }

    @PostMapping("/tasks/update/{id}")
    public String updateTask(@PathVariable Long id, Task task)
    {
        service.updateTask(id, task);

        return "redirect:/";
    }



}
