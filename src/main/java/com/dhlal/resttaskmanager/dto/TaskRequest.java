package com.dhlal.resttaskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private LocalDate dueDate;
}