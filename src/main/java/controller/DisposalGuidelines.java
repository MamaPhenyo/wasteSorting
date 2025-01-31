package controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class DisposalGuidelines {
    @Autowired
    private DisposalGuidelinesRespository disposalGuidelinesRespository;

    @GetMapping//Reading
    public ResponseEntity<List<DisposalGuideLines>> getAllDisposalGuidelines() {
        //Retrieve disposal guidelines from the repo
        List<DisposalGuidelines> disposalGuidelines = disposalGuidelinesRepository.findAll();
        //Retrieved data
        return ResponseEntity.ok(disposalGuidelines);
    }

    @PostMapping//Creating
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@Valid @RequestBody DisposalGuidelines disposalGuideline) {
        //save the new disposal guideline created
        DisposalGuidelines createDisposalGuideline = disposalGuidelinesRepository.save(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}")//Updating
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines updatedDisposalGuideline){
        Optional<DisposalGuidelines> existingDisposalGuidelineOptional = disposalGuidelinesRepository.findById(id);
        if (existingDisposalGuidelineOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DisposalGuidelines existingDisposalGuideline = existingDisposalGuidelineOptional.get();
        existingDisposalGuideline.setId(updateDisposalGuideline.getId());

        DisposalGuidelines savedDisposalGuideline = disposalGuidelinesRepository.save(existingDisposalGuideline);
        return ResponseEntity.ok(savedDisposalGuideline);
    }
}
