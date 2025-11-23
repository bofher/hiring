package com.hiring.hiringBE.repo;

import com.hiring.hiringBE.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
