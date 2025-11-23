package com.hiring.hiringBE.controllers;

import com.hiring.hiringBE.model.Application;
import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private ApplicationService service;

    public ApplicationController(ApplicationService applicationService) {
        this.service = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<Application>> getApplications() {
        List<Application> applications = service.getApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable Integer id) {
        Application application = service.getApplication(id);
        return ResponseEntity.ok(application);
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application saved = service.addApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Integer id) {
        service.deleteApplication(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
