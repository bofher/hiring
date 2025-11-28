package com.hiring.hiringBE.service;

import com.hiring.hiringBE.DTOs.Candidate.CandidateDTO;
import com.hiring.hiringBE.exception.ResourceNotFoundException;
import com.hiring.hiringBE.model.Candidate;
import com.hiring.hiringBE.repo.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    public CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public Candidate addCandidate(Candidate candidate) {
        return  repository.save(candidate);
    }

    public CandidateDTO getCandidateById(int id) {
        Candidate candidate = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id " + id));
        return  new CandidateDTO(
                candidate.getId(),
                candidate.getName(),
                candidate.getPhone(),
                candidate.getAddress(),
                candidate.getInfo()
        );
    }

    public List<CandidateDTO> getCandidates() {
        List<Candidate> candidates = repository.findAll();
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        for (Candidate candidate : candidates) {
            candidateDTOS.add(new CandidateDTO(
                    candidate.getId(),
                    candidate.getName(),
                    candidate.getPhone(),
                    candidate.getAddress(),
                    candidate.getInfo()
            ));
        }
        return candidateDTOS;
    }

    public void updateCandidate(Candidate candidate) {
        repository.save(candidate);
    }

    public void deleteCandidate(int id) {
        repository.deleteById(id);
    }

    public int getCountByRegion(String regionName) {
        return repository.getCountByRegion(regionName);
    }

    public Candidate getCandidateEntityById(int id) {
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id " + id));
    }
}
