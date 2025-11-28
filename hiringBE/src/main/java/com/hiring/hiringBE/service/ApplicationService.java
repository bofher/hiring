package com.hiring.hiringBE.service;

import com.hiring.hiringBE.DTOs.Application.ApplicationDTO;
import com.hiring.hiringBE.exception.ResourceNotFoundException;
import com.hiring.hiringBE.model.Application;
import com.hiring.hiringBE.repo.ApplicationRepository;
import com.hiring.hiringBE.repo.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {
    private final CandidateService candidateService;
    private final PositionService positionService;
    public ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository, CandidateService candidateService, PositionService positionService) {
        this.repository = repository;
        this.candidateService = candidateService;
        this.positionService = positionService;
    }

    public ApplicationDTO addApplication(ApplicationDTO dto) {
        Application app  = new Application();
        app.setCandidate(candidateService.getCandidateEntityById(dto.candidateId()));
        app.setPosition(positionService.getPositionEntityById(dto.positionId()));
        app.setStatus("pending");

        app = repository.save(app);
        return new ApplicationDTO(
                app.getId(),
                app.getCandidate().getId(),
                app.getPosition().getId()
        );
    }

    public ApplicationDTO getApplication(int id) {
        Application app = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No applications with id"));
        return new ApplicationDTO(
                app.getId(),
                app.getCandidate().getId(),
                app.getPosition().getId()
        );
    }

    public List<ApplicationDTO> getApplications() {
        List<Application> apps = repository.findAll();
        List<ApplicationDTO> dtos = new ArrayList<>();
        for (Application app : apps) {
            dtos.add(new ApplicationDTO(
                    app.getId(),
                    app.getCandidate().getId(),
                    app.getPosition().getId()
            ));
        }
        return dtos;
    }

    public void deleteApplication(Integer id) {
        repository.deleteById(id);
    }
}
