package com.hiring.hiringBE.service;

import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.repo.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    public DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public void addDepartment(Department department) {
        repository.save(department);
    }

    public List<Department> getAllDepartment() {
        return repository.findAll();
    }

    public Department getDepartmentById(int id) {
        return repository.findById(id).orElse(null);
    }
    public void deleteDepartment(Integer id) {
        repository.deleteById(id);
    }
}

