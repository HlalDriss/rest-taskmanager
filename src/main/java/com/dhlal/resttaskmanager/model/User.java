package com.dhlal.resttaskmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users") // 'user' is a reserved word in PostgreSQL
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
