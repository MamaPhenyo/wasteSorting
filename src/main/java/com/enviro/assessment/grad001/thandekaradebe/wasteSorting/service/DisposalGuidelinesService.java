package com.enviro.assessment.grad001.thandekaradebe.wasteSorting.service;

import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.model.DisposalGuidelines;
import com.enviro.assessment.grad001.thandekaradebe.wasteSorting.repository.DisposalGuidelinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelinesService {
    @Autowired
    private DisposalGuidelinesRepository disposalGuidelinesRepository;

    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelinesRepository.findAll();
    }

    public Optional<DisposalGuidelines> getDisposalGuidelinesById(Long id) {
        return disposalGuidelinesRepository.findById(id);
    }

    public DisposalGuidelines createDisposalGuidelines(DisposalGuidelines disposalGuidelines) {
        return disposalGuidelinesRepository.save(disposalGuidelines);
    }

    public Optional<DisposalGuidelines> updateDisposalGuidelines(Long id, DisposalGuidelines updateDisposalGuidelines) {
        Optional<DisposalGuidelines> existingGuidelinesOptional = disposalGuidelinesRepository.findById(id);
        if (existingGuidelinesOptional.isPresent()) {
            DisposalGuidelines existingGuidelines = existingGuidelinesOptional.get();
            existingGuidelines.setCategory(updatedDisposalGuidelines.getCategory());
            existingGuidelines.setGuidelines(updatedDisposalGuidelines.getGuidelines());
            return Optional.of(disposalGuidelinesRepository.save(existingGuidelines));
        } else {
            return Optional.empty();
        }
    }
    public void deleteDisposalGuidelines(Long id) {
        disposalGuidelinesRepository.deleteById(id);
    }

}
