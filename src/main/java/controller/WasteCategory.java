package controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategory {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @GetMapping //Reading
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteCategory.findAll();
        return ResponseEntity.ok(wasteCategories);
    }

    @PostMapping //Creating
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory createdWasteCategory = wasteCategoryRepository.save(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> createWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory updatedWasteCategory) {
        Optional<WasteCategory> existingWasteCategoryOptional = wasteCategoryRepository.findById(id);
        if (existingWasteCategoryOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        WasteCategory existingWasteCategory = existingWasteCategoryOptional.get();
        existingWasteCategory.setName(updatedWasteCategory.getName());
        existingWasteCategory.setId(updatedWasteCategory.getId());
        WasteCategory savedWasteCategory = wasteCategoryRepository.save(existingWasteCategory);
        return ResponseEntity.ok(savedWasteCategory);
    }

}
