package com.hiring.hiringBE.service;

import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.model.Position;
import com.hiring.hiringBE.repo.PositionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PositionService {
    public PositionRepository repository;

    public PositionService(PositionRepository repository) {
        this.repository = repository;
    }

    public void addPosition(Position position) {
        repository.save(position);
    }

    public List<Position> getPositions() {
        return repository.findAll();
    }

    public List<Position> getPositionsByDepartment(Department department) {
        return repository.findByDepartment(department);
    }

    public List<Position> getPositionsByTitle(String title) {
        return repository.findByTitle(title);
    }

    public void deletePosition(Position position) {
        repository.delete(position);
    }
}
