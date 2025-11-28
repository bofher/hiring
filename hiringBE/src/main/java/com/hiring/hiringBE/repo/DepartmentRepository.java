package com.hiring.hiringBE.repo;

import com.hiring.hiringBE.DTOs.Department.TopDeptSalaries;
import com.hiring.hiringBE.model.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "SELECT * FROM TopDeptSalaries(:deptId)", nativeQuery = true)
    List<TopDeptSalaries> findTopSalariesByDept(@Param("deptId") int deptId);

    @Modifying
    @Transactional
    @Query(value = "EXEC mark_salaries :deptId", nativeQuery = true)
    void markSalaries(@Param("deptId") int deptId);
}
