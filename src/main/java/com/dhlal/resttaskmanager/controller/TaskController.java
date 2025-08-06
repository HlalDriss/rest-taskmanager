package com.dhlal.resttaskmanager.controller;

import com.dhlal.resttaskmanager.dto.TaskRequest;
import com.dhlal.resttaskmanager.dto.TaskResponse;
import com.dhlal.resttaskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}