package com.example.practicewebapp.service;

import com.example.practicewebapp.model.PracticeData;
import com.example.practicewebapp.repository.PracticeDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeDataService {

    private final PracticeDataRepository practiceDataRepository;

    public PracticeDataService(PracticeDataRepository practiceDataRepository) {
        this.practiceDataRepository = practiceDataRepository;
    }

    public List<PracticeData> getAllPracticeData() {
        return practiceDataRepository.findAll();
    }

    public void toggleCompletedById(int id, boolean completed) {
        PracticeData practiceData = getPracticeDataById(id);
        if (practiceData != null) {
            practiceData.setCompleted(completed);
            savePracticeData(practiceData);
        }
    }

    public PracticeData getPracticeDataById(int id) {
        return practiceDataRepository.findById(id).orElse(null);
    }

    public void savePracticeData(PracticeData practiceData) {
        practiceDataRepository.save(practiceData);
    }

    public void deletePracticeDataById(int id) {
        practiceDataRepository.deleteById(id);
    }
}
