package com.example.practicewebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PracticeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String description;
    public boolean completed;

    public PracticeData() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public PracticeData(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
