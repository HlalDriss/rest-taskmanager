package com.dhlal.resttaskmanager.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
}