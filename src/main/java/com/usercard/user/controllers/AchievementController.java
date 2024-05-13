package com.usercard.user.controllers;

import com.usercard.user.dtos.AchievementDto;
import com.usercard.user.services.AchievementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/achievement")
@CrossOrigin(origins = "http://localhost:3000")
public class AchievementController {
    private final AchievementService achievementService;

    @GetMapping("/get-achievement")
    public List<AchievementDto> getAchievement() {
        return achievementService.showAllAchievements();
    }

    @PostMapping("/get-achievement-by-id")
    public AchievementDto showAchievementDto(@RequestParam long id) {
        return achievementService.showAchievementsDto(id);
    }

    @PostMapping("/save-all-achievement")
    public boolean saveAchievement(@RequestBody List<AchievementDto> dto) {
        return achievementService.addAchievementsList(dto);
    }

    @PutMapping("/update-achievement")
    public boolean updateAchievement(@RequestBody AchievementDto dto) {
        return achievementService.updateAchievements(dto);
    }

    @DeleteMapping("/delete-achievement-by-id")
    public boolean deleteAchievementById(@RequestParam long id) {
        return achievementService.deleteAchievementsById(id);
    }
}
