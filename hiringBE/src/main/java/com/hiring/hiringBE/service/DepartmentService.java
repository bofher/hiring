package com.hiring.hiringBE.service;

import com.hiring.hiringBE.DTOs.Department.DepartmentDTO;
import com.hiring.hiringBE.DTOs.Department.DepartmentDetailed;
import com.hiring.hiringBE.DTOs.Department.TopDeptSalaries;
import com.hiring.hiringBE.DTOs.Position.PositionDTO;
import com.hiring.hiringBE.exception.ResourceNotFoundException;
import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.model.Position;
import com.hiring.hiringBE.repo.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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

    public List<DepartmentDTO> getAllDepartment() {
        List<Department> deps = repository.findAll();
        List<DepartmentDTO> dtos = new ArrayList<>();
        for (Department dep : deps) {
            dtos.add(new DepartmentDTO(dep.getId(), dep.getName(), dep.getDescription()));
        }
        return dtos;
    }

    public DepartmentDTO getDepartmentById(int id) {
        Department department = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No department with id " + id));
        return new DepartmentDTO(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }

    public DepartmentDetailed getDetailedDepartments(int id) {
        Department department = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No department with id " + id));

        List<PositionDTO> positions = new ArrayList<>();
        for(Position pos :  department.getPositions()) {
            positions.add(new PositionDTO(
                    pos.getId(),
                    pos.getTitle(),
                    pos.getSalary(),
                    pos.getRequirements(),
                    pos.getDepartment().getId(),
                    pos.getDescription(),
                    pos.getDepartment().getName()

            ));
        }
        return new DepartmentDetailed(
                department.getId(),
                department.getName(),
                department.getDescription(),
                positions
        );
    }

    public void deleteDepartment(Integer id) {
        repository.deleteById(id);
    }

    public List<TopDeptSalaries> getTopDeptSalaries(int id) {
        return repository.findTopSalariesByDept(id);
    }

    public void markSalaries(int id) {
        repository.markSalaries(id);
    }
}

