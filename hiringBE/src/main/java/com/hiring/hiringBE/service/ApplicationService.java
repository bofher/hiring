package com.hiring.hiringBE.service;

import com.hiring.hiringBE.model.Application;
import com.hiring.hiringBE.repo.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    public ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public Application addApplication(Application application) {
        return repository.save(application);
    }

    public Application getApplication(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Application> getApplications() {
        return repository.findAll();
    }

    public void deleteApplication(Integer id) {
        repository.deleteById(id);
    }
}
