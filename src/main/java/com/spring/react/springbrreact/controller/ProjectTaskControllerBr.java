package com.spring.react.springbrreact.controller;

import com.spring.react.springbrreact.dao.ProjectTask;
import com.spring.react.springbrreact.service.ServiceBR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/board")
@CrossOrigin
public class ProjectTaskControllerBr {

    @Autowired
    ServiceBR serviceBR;

    @PostMapping(value = "/save")
    public ResponseEntity<?> methodPostSaveUpDate(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        /*Error*/
        if (result.hasErrors()) {
            Map<String, String> mapError = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                mapError.put(error.getField(), error.getDefaultMessage());
                return new ResponseEntity<Map<String, String>>(mapError, HttpStatus.BAD_REQUEST);
            }
        }

        ProjectTask prTask = serviceBR.methodSaveUpdate(projectTask);

        return new ResponseEntity<ProjectTask>(prTask, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<ProjectTask>> methodGet() {
        List<ProjectTask> all = serviceBR.getAll();
        return new ResponseEntity<List<ProjectTask>>(all,HttpStatus.OK);
    }

    @GetMapping(value = "/getid/{id}")
    public ResponseEntity<ProjectTask> methodGetId(@PathVariable("id") Long id) {
        Optional<ProjectTask> projectTask = serviceBR.getId(id);
        ProjectTask projectTask1 = projectTask.get();
        return new ResponseEntity<ProjectTask>(projectTask1, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> methodDelete(@PathVariable("id") Long id){
                serviceBR.methodDelete(id);
        return new ResponseEntity<String>("Delete : " +id,HttpStatus.OK);
    }
}
