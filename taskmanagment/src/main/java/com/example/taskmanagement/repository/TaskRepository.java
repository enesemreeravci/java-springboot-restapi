package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
// we will get automatically these methods
// findAll,    findById, save, deleteById
// spring provides these methods for us
public interface TaskRepository extends JpaRepository<Task, Long> {

}