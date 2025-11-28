package com.hiring.hiringBE.DTOs.Department;

import java.math.BigDecimal;

public record TopDeptSalaries(
        int positionId,
        String title,
        BigDecimal salary,
        Integer deptId,
        String userName
) {
}
