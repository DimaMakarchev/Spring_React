package com.spring.react.springbrreact.repo;

import com.spring.react.springbrreact.dao.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoBr extends JpaRepository<ProjectTask,Long> {
    Optional<ProjectTask> findById(Long id);
}
