package com.example.practicewebapp.repository;

import com.example.practicewebapp.model.PracticeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeDataRepository extends JpaRepository<PracticeData, Integer> {

}
