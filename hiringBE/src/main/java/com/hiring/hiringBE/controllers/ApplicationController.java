package com.hiring.hiringBE.controllers;

import com.hiring.hiringBE.DTOs.Application.ApplicationDTO;
import com.hiring.hiringBE.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService service;

    public ApplicationController(ApplicationService applicationService) {
        this.service = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> getApplications() {
        List<ApplicationDTO> applications = service.getApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplication(@PathVariable Integer id) {
        ApplicationDTO application = service.getApplication(id);
        return ResponseEntity.ok(application);
    }

    @PostMapping
    public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO application) {
        ApplicationDTO saved = service.addApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Integer id) {
        service.deleteApplication(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
