package com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    Optional<WasteCategory> findByName(String name);
}
