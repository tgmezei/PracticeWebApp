package com.example.practicewebapp.controller;

import com.example.practicewebapp.model.PracticeData;
import com.example.practicewebapp.service.PracticeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PracticeController {
    private final PracticeDataService practiceDataService;

    public PracticeController(PracticeDataService practiceDataService) {
        this.practiceDataService = practiceDataService;
    }

    @GetMapping
    public String listPracticeData(Model model) {
        model.addAttribute("practiceData", practiceDataService.getAllPracticeData());
        model.addAttribute("newPracticeData", new PracticeData());
        return "index";
    }

    @PostMapping
    public String addPracticeData(@ModelAttribute("newPracticeData") PracticeData newPracticeData) {
        practiceDataService.savePracticeData(newPracticeData);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deletePracticeData(@PathVariable int id) {
        practiceDataService.deletePracticeDataById(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String togglePracticeData(@PathVariable int id, @RequestParam(name = "completed", defaultValue = "false") boolean completed) {
        practiceDataService.toggleCompletedById(id, completed);
        return "redirect:/";
    }
}
