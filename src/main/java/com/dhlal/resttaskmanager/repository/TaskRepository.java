package com.dhlal.resttaskmanager.repository;


import com.dhlal.resttaskmanager.model.Task;
import com.dhlal.resttaskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
