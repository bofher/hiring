package com.hiring.hiringBE.controllers;

import com.hiring.hiringBE.DTOs.Position.PositionDTO;
import com.hiring.hiringBE.model.Position;
import com.hiring.hiringBE.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/positions")
class PositionController {
    private final PositionService service;

    public PositionController(PositionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll() {
        List<PositionDTO> res = service.getPositions();
        return  ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDTO> findById(@PathVariable int id) {
        PositionDTO pos = service.getPositionById(id);
        return  ResponseEntity.ok(pos);
    }

    @PostMapping
    public ResponseEntity<PositionDTO> createPosition(@Valid @RequestBody PositionDTO pos) {
        PositionDTO savedDto = service.addPosition(pos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);

    }


}
