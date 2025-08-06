package com.dhlal.resttaskmanager.service;

import com.dhlal.resttaskmanager.dto.TaskRequest;
import com.dhlal.resttaskmanager.dto.TaskResponse;
import com.dhlal.resttaskmanager.model.Task;
import com.dhlal.resttaskmanager.model.User;
import com.dhlal.resttaskmanager.repository.TaskRepository;
import com.dhlal.resttaskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email).orElseThrow();
    }

    public List<TaskResponse> getAllTasks() {
        User user = getCurrentUser();
        return taskRepository.findByUser(user).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TaskResponse getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        return toResponse(task);
    }

    public TaskResponse createTask(TaskRequest request) {
        User user = getCurrentUser();

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .completed(false)
                .user(user)
                .build();

        return toResponse(taskRepository.save(task));
    }

    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id).orElseThrow();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());

        return toResponse(taskRepository.save(task));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
    }
}