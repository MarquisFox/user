package com.usercard.user.services;

import com.usercard.user.converters.InstituteConverter;
import com.usercard.user.converters.PersonConverter;
import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.dtos.PersonDto;
import com.usercard.user.repo.InstituteRepo;
import com.usercard.user.repo.PersonRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PersonService {

    private final PersonRepo personRepo;
    private final Random random = new Random();

    public List<PersonDto> showAllPersons() {
        return personRepo.findAll().stream().map(PersonConverter::toDto).collect(Collectors.toList());
    }

    public PersonDto showPersonsDto(long id) {
        return PersonConverter.toDto(personRepo.findById(id).get());
    }

    public boolean addPersonsList(List<PersonDto> dtoList) {
        personRepo.saveAll(dtoList.stream().map(PersonConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updatePersons(PersonDto dto) {
        if (personRepo.existsById(dto.getId())) {
            personRepo.save(PersonConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deletePersonsById(long id) {
        personRepo.deleteById(id);
        return true;
    }

    public PersonDto findPersonByFilter(String groupName, String instituteName) {
        return PersonConverter.toDto(personRepo.findByFilter(groupName,instituteName));
    }
}
