package com.hiring.hiringBE.DTOs.Candidate;

public record CandidateDTO(
        int id,
        String name,
        String phone,
        String address,
        String info
) {
}
