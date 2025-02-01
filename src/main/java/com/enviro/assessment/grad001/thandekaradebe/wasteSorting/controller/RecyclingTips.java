package com.enviro.assessment.grad001.thandekaradebe.wasteSorting.controller;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository.RecyclingTipsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recycling-tips")
public class RecyclingTips {
    @Autowired
    private RecyclingTipsRepository recyclingTipsRepository;

    @GetMapping
    public ResponseEntity<List<RecyclingTips>> getAllRecyclingTips() {
        List<RecyclingTips> recyclingTips = recyclingTipsRepository.findAll();
        return ResponseEntity.ok(recyclingTips);
    }

    @PostMapping
    public ResponseEntity<RecyclingTips> createRecyclingTip(@Valid @RequestBody RecyclingTips recyclingTip) {
        RecyclingTips createdRecyclingTip = recyclingTipsRepo.save(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTips> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTips updatedRecyclingTip) {
        Optional<RecyclingTips> existingRecyclingTipOptional = recyclingTipsRepository.findById(id);
        if (existingRecyclingTipOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        RecyclingTips existingRecyclingTip = existingWasteCategoryOptional.get();
        existingRecyclingTip.setTip(updatedRecyclingTip.getTip());
        existingRecyclingTip.setTip(updatedRecyclingTip.getTip());
        RecyclingTips savedRecyclingTip = recyclingTipsRepository.save(existingRecyclingTip);
        return ResponseEntity.ok(savedRecyclingTip);
    }


}
