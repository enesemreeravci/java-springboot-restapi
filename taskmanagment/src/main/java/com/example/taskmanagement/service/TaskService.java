package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        task.setPriority(updatedTask.getPriority());
        task.setDueDate(updatedTask.getDueDate());

        return repository.save(task);
    }

    public Task toggleCompleted(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(!task.isCompleted());

        return repository.save(task);
    }

    public List<Task> searchTasks(String keyword)
    {
        if(keyword == null || keyword.isBlank())
        {
            return repository.findAll();
        }
        return repository.findByTitleContainingIgnoreCase(keyword);
    }

    public  List<Task> filterTasks(String status)
    {
        if(status == null || status.equals("all"))
        {
            return repository.findAll();
        }
        if(status.equals("completed"))
        {
            return repository.findByCompleted(true);
        }
        if(status.equals("pending"))
        {
            return repository.findByCompleted(false);
        }
        if(status.equals("high"))
        {
            return repository.findByPriority("HIGH");
        }
        return repository.findAll();
    }

}
