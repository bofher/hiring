package com.hiring.hiringBE.DTOs.Department;

import com.hiring.hiringBE.DTOs.Position.PositionDTO;

import java.util.List;

public record DepartmentDetailed(
        int id,
        String name,
        String description,
        List<PositionDTO> positions
) {
}
