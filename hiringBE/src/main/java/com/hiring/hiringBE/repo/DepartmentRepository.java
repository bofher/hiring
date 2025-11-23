package com.hiring.hiringBE.repo;

import com.hiring.hiringBE.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {


}
