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
import java.util.List;

@Controller
public class HomeController {

    private final TaskService service;

    public HomeController(TaskService service)
    {
        this.service = service;
    }

    @GetMapping("/")
    public String printIndex(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "all") String status,
            Model model) {

        List<Task> tasks;

        if (keyword != null && !keyword.isBlank()) {
            tasks = service.searchTasks(keyword);
        } else {
            tasks = service.filterTasks(status);
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("keyword", keyword);
        model.addAttribute("status", status);

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
