package com.hiring.hiringBE.controllers;


import com.hiring.hiringBE.DTOs.Candidate.CandidateDTO;
import com.hiring.hiringBE.model.Candidate;
import com.hiring.hiringBE.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
class CandidateController {

    private final CandidateService service;

    public CandidateController(CandidateService candidateService) {
        this.service = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getCandidates() {
        List<CandidateDTO> candidates = service.getCandidates();
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getCandidate(@PathVariable Integer id) {
        CandidateDTO candidate = service.getCandidateById(id);
        return ResponseEntity.ok(candidate);
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate saved = service.addCandidate(candidate);
        return  ResponseEntity.ok(saved);
    }

    @GetMapping("/countByRegion/{regionName}")
    public ResponseEntity<Integer> getCountByRegion(@PathVariable String regionName) {
        return ResponseEntity.ok(service.getCountByRegion(regionName));
    }


}
