package com.usercard.user.services;

import com.usercard.user.converters.EventConverter;
import com.usercard.user.dtos.EventDto;
import com.usercard.user.repo.EventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepo eventRepo;
    private final Random random = new Random();

    public List<EventDto> showAllEvents() {
        return eventRepo.findAll().stream().map(EventConverter::toDto).collect(Collectors.toList());
    }

    public EventDto showEventsDto(long id) {
        return EventConverter.toDto(eventRepo.findById(id).get());
    }

    public boolean addEventsList(List<EventDto> dtoList) {
        eventRepo.saveAll(dtoList.stream().map(EventConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateEvents(EventDto dto) {
        if (eventRepo.existsById(dto.getId())) {
            eventRepo.save(EventConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteEventsById(long id) {
        eventRepo.deleteById(id);
        return true;
    }
}
