package com.hiring.hiringBE.service;

import com.hiring.hiringBE.model.Candidate;
import com.hiring.hiringBE.repo.CandidateRepository;
import org.springframework.stereotype.Service;

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

    public Candidate getCandidateById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Candidate> getCandidates() {
        return repository.findAll();
    }

    public void updateCandidate(Candidate candidate) {
        repository.save(candidate);
    }

    public void deleteCandidate(int id) {
        repository.deleteById(id);
    }
}
