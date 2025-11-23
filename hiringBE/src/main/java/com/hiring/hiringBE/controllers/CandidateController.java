package com.hiring.hiringBE.controllers;


import com.hiring.hiringBE.model.Candidate;
import com.hiring.hiringBE.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
class CandidateController {

    private CandidateService service;

    public CandidateController(CandidateService candidateService) {
        this.service = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getCandidates() {
        List<Candidate> candidates = service.getCandidates();
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable Integer id) {
        Candidate candidate = service.getCandidateById(id);
        return ResponseEntity.ok(candidate);
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate saved = service.addCandidate(candidate);
        return  ResponseEntity.ok(saved);
    }
}
