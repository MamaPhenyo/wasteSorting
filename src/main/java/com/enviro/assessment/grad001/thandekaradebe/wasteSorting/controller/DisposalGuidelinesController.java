package com.enviro.assessment.grad001.thandekaradebe.wasteSorting.controller;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.model.DisposalGuidelines;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository.DisposalGuidelinesRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disposal-guidelines")
public class DisposalGuidelinesController {
    @Autowired
    private DisposalGuidelinesRepository disposalGuidelinesRepository;

    @GetMapping//Reading
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        //Retrieve disposal guidelines from the repo
        List<DisposalGuidelines> disposalGuidelines = disposalGuidelinesRepository.findAll();
        //Retrieved data
        return ResponseEntity.ok(disposalGuidelines);
    }

    @PostMapping//Creating
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@Valid @RequestBody DisposalGuidelines disposalGuideline) {
        //save the new disposal guideline created
        DisposalGuidelines createdDisposalGuideline = disposalGuidelinesRepository.save(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}")//Updating
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines updatedDisposalGuideline){
        Optional<DisposalGuidelines> existingDisposalGuidelineOptional = disposalGuidelinesRepository.findById(id);
        if (existingDisposalGuidelineOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DisposalGuidelines existingDisposalGuideline = existingDisposalGuidelineOptional.get();
        existingDisposalGuideline.setId(updatedDisposalGuideline.getId());

        DisposalGuidelines savedDisposalGuideline = disposalGuidelinesRepository.save(existingDisposalGuideline);
        return ResponseEntity.ok(savedDisposalGuideline);
    }

    @DeleteMapping("/{id}") //deleting
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        if (!disposalGuidelinesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        disposalGuidelinesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
