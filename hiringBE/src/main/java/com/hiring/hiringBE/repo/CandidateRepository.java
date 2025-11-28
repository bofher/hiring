package com.hiring.hiringBE.repo;

import com.hiring.hiringBE.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    @Query(value = "SELECT dbo.get_count_by_region(:name)",nativeQuery = true)
    public int getCountByRegion(@Param("name") String regionName);


}
