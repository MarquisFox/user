package com.usercard.user.services;

import com.usercard.user.converters.InstituteConverter;
import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.repo.InstituteRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class InstituteService {
    private final InstituteRepo instituteRepo;
    private final Random random = new Random();

    public List<InstituteDto> showAllInstitutes() {
        return instituteRepo.findAll().stream().map(InstituteConverter::toDto).collect(Collectors.toList());
    }

    public InstituteDto showInstitutesDto(long id) {
        return InstituteConverter.toDto(instituteRepo.findById(id).get());
    }

    public boolean addInstitutesList(List<InstituteDto> dtoList) {
        instituteRepo.saveAll(dtoList.stream().map(InstituteConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateInstitutes(InstituteDto dto) {
        if (instituteRepo.existsById(dto.getId())) {
            instituteRepo.save(InstituteConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteInstitutesById(long id) {
        instituteRepo.deleteById(id);
        return true;
    }
}
