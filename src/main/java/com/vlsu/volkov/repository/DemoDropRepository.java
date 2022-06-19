package com.vlsu.volkov.repository;

import com.vlsu.volkov.model.DemoDrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDropRepository extends JpaRepository<DemoDrop, Integer> {
}
