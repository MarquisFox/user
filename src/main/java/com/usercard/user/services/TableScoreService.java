package com.usercard.user.services;

import com.usercard.user.converters.PersonConverter;
import com.usercard.user.converters.TableScoreConverter;
import com.usercard.user.dtos.TableScoreDto;
import com.usercard.user.repo.TableScoreRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class TableScoreService {
    private final TableScoreRepo tableScoreRepo;
    private final Random random = new Random();

    public List<TableScoreDto> showAllTableScores() {
        return tableScoreRepo.findAll().stream().map(TableScoreConverter::toDto).collect(Collectors.toList());
    }

    public TableScoreDto showTableScoresDto(long id) {
        return TableScoreConverter.toDto(tableScoreRepo.findById(id).get());
    }

    public boolean addTableScoresList(List<TableScoreDto> dtoList) {
        tableScoreRepo.saveAll(dtoList.stream().map(TableScoreConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateTableScores(TableScoreDto dto) {
        if (tableScoreRepo.existsById(dto.getId())) {
            tableScoreRepo.save(TableScoreConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteTableScoresById(long id) {
        tableScoreRepo.deleteById(id);
        return true;
    }
}
