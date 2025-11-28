package com.hiring.hiringBE.DTOs.Application;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ApplicationDTO(
        int id,
        @JsonProperty("candidate_id")
        int candidateId,
        @JsonProperty("position_id")
        int positionId

) {
}
