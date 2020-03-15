package com.spring.react.springbrreact.service;

import com.spring.react.springbrreact.dao.ProjectTask;
import com.spring.react.springbrreact.repo.RepoBr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBR {

    @Autowired
    RepoBr repoBr;

    public ProjectTask methodSaveUpdate(ProjectTask projectTask) {

        if (projectTask.getStatus() == null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO DO");
        }

        repoBr.save(projectTask);
        return projectTask;
    }

    public List<ProjectTask> getAll() {
        return repoBr.findAll();
    }

    public Optional<ProjectTask> getId(Long id) {

        return repoBr.findById(id);
    }

    public void methodDelete(Long id) {
        Optional<ProjectTask> byId = repoBr.findById(id);
        ProjectTask projectTask = byId.get();
        repoBr.delete(projectTask);
    }
}
