package com.usercard.user.services;

import com.usercard.user.converters.AchievmentsConverter;
import com.usercard.user.dtos.AchievmentsDto;
import com.usercard.user.repo.AchievmentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AchievmentsService {
    private final AchievmentsRepo achievmentsRepo;
    private final Random random = new Random();

    public List<AchievmentsDto> showAllAchievments() {
        return achievmentsRepo.findAll().stream().map(AchievmentsConverter::toDto).collect(Collectors.toList());
    }

    public AchievmentsDto showAchievmentsDto(long id) {
        return AchievmentsConverter.toDto(achievmentsRepo.findById(id).get());
    }

    public boolean addAchievmentsList(List<AchievmentsDto> dtoList) {
        achievmentsRepo.saveAll(dtoList.stream().map(AchievmentsConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateAchievments(AchievmentsDto dto) {
        if (achievmentsRepo.existsById(dto.getId())) {
            achievmentsRepo.save(AchievmentsConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteAchievmentsById(long id) {
        achievmentsRepo.deleteById(id);
        return true;
    }
}