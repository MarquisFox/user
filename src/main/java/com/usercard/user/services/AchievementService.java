package com.usercard.user.services;

import com.usercard.user.converters.AchievementConverter;
import com.usercard.user.dtos.AchievementDto;
import com.usercard.user.repo.AchievementRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AchievementService {
    private final AchievementRepo achievementRepo;
    private final Random random = new Random();

    public List<AchievementDto> showAllAchievements() {
        return achievementRepo.findAll().stream().map(AchievementConverter::toDto).collect(Collectors.toList());
    }

    public AchievementDto showAchievementsDto(long id) {
        return AchievementConverter.toDto(achievementRepo.findById(id).get());
    }

    public boolean addAchievementsList(List<AchievementDto> dtoList) {
        achievementRepo.saveAll(dtoList.stream().map(AchievementConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateAchievements(AchievementDto dto) {
        if (achievementRepo.existsById(dto.getId())) {
            achievementRepo.save(AchievementConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteAchievementsById(long id) {
        achievementRepo.deleteById(id);
        return true;
    }
}