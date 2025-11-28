package com.hiring.hiringBE.service;

import com.hiring.hiringBE.exception.ResourceNotFoundException;
import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.model.Position;
import com.hiring.hiringBE.repo.DepartmentRepository;
import com.hiring.hiringBE.repo.PositionRepository;
import org.springframework.stereotype.Service;
import com.hiring.hiringBE.DTOs.Position.PositionDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService {
    private final DepartmentRepository departmentRepository;
    public PositionRepository repository;

    public PositionService(PositionRepository repository, DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    public PositionDTO addPosition(PositionDTO dto) {
        Position position = new Position();
        position.setTitle(dto.title());
        position.setDescription(dto.description());
        position.setDepartment(departmentRepository.findById(dto.departmentId()).orElseThrow(() -> new ResourceNotFoundException("No department with id " + dto.departmentId())));
        position.setSalary(dto.salary());
        position.setRequirements(dto.requirements());

        Position saved = repository.save(position);
        return new PositionDTO(
                saved.getId(),
                saved.getTitle(),
                saved.getSalary(),
                saved.getRequirements(),
                saved.getDepartment().getId(),
                saved.getDescription(),
                saved.getDepartment().getName()
        );
    }

    public List<PositionDTO> getPositions() {
        List<Position> positions = repository.findAll();
        List<PositionDTO> res = new ArrayList<>();

        for (Position pos : positions) {
            res.add(new PositionDTO(
                    pos.getId(),
                    pos.getTitle(),
                    pos.getSalary(),
                    pos.getRequirements(),
                    pos.getDepartment().getId(),
                    pos.getDescription(),
                    pos.getDepartment().getName()
            ));
        }
        return res;
    }

    public PositionDTO getPositionById(int id) {
        Position pos = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position not found with id: " + id));
        return new PositionDTO(
                pos.getId(),
                pos.getTitle(),
                pos.getSalary(),
                pos.getRequirements(),
                pos.getDepartment().getId(),
                pos.getDescription(),
                pos.getDepartment().getName()
        );
    }


    public void deletePosition(Position position) {
        repository.delete(position);
    }

    public Position getPositionEntityById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position not found with id: " + id));
    }
}
