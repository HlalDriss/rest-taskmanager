package com.dhlal.resttaskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
