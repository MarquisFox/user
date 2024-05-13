package com.usercard.user.services;


import com.usercard.user.converters.GroupConverter;
import com.usercard.user.dtos.EventDto;
import com.usercard.user.dtos.GroupDto;
import com.usercard.user.repo.GroupRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class GroupService {
    private final GroupRepo groupRepo;
    private final Random random = new Random();

    public List<GroupDto> showAllGroups() {
        return groupRepo.findAll().stream().map(GroupConverter::toDto).collect(Collectors.toList());
    }

    public GroupDto showGroupsDto(long id) {
        return GroupConverter.toDto(groupRepo.findById(id).get());
    }

    public boolean addGroupsList(List<GroupDto> dtoList) {
        groupRepo.saveAll(dtoList.stream().map(GroupConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateGroups(GroupDto dto) {
        if (groupRepo.existsById(dto.getId())) {
            groupRepo.save(GroupConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteGroupsById(long id) {
        groupRepo.deleteById(id);
        return true;
    }
}
