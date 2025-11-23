package com.hiring.hiringBE.controllers;

import com.hiring.hiringBE.model.Department;
import com.hiring.hiringBE.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        service.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> departments = service.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Integer id) {
        try{
            Department department = service.getDepartmentById(id);
            if (department == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(department);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Integer id) {
        service.deleteDepartment(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
