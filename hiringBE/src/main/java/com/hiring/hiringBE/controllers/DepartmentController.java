package com.hiring.hiringBE.controllers;

import com.hiring.hiringBE.DTOs.Department.DepartmentDTO;
import com.hiring.hiringBE.DTOs.Department.DepartmentDetailed;
import com.hiring.hiringBE.DTOs.Department.TopDeptSalaries;
import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        service.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        List<DepartmentDTO> departments = service.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Integer id) {
        DepartmentDTO department = service.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<DepartmentDetailed> getDepartmentDetails(@PathVariable Integer id) {
        DepartmentDetailed deps = service.getDetailedDepartments(id);
        return ResponseEntity.ok(deps);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.deleteDepartment(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/topDeptSalaries/{id}")
    public ResponseEntity<List<TopDeptSalaries>> getTopDeptSalaries(@PathVariable Integer id) {
        List<TopDeptSalaries> res = service.getTopDeptSalaries(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/mark-salaries/{deptId}")
    public ResponseEntity<String> markSalaries(@PathVariable int deptId) {
        service.markSalaries(deptId);
        return ResponseEntity.status(HttpStatus.OK).body("Marked successfully");
    }
}
