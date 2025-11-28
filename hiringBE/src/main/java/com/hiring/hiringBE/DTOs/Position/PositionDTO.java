package com.hiring.hiringBE.DTOs.Position;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;


import java.math.BigDecimal;

public record PositionDTO(
    int id,
    String title,
    @DecimalMin(value = "0.0", inclusive = false)
    BigDecimal salary,
    String requirements,
    @JsonProperty("department_id")
    int departmentId,
    String description,
    String deptName
) {

}
