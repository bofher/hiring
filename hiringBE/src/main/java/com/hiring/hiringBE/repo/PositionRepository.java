package com.hiring.hiringBE.repo;

import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    List<Position> findByDepartment(Department department);;
    List<Position>findByTitle(String title);
}
