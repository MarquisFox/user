package com.usercard.user.services;

import com.usercard.user.converters.EventsConverter;
import com.usercard.user.dtos.EventsDto;
import com.usercard.user.repo.EventsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventsService {
    private final EventsRepo eventsRepo;
    private final Random random = new Random();

    public List<EventsDto> showAllEvents() {
        return eventsRepo.findAll().stream().map(EventsConverter::toDto).collect(Collectors.toList());
    }

    public EventsDto showEventsDto(long id) {
        return EventsConverter.toDto(eventsRepo.findById(id).get());
    }

    public boolean addEventsList(List<EventsDto> dtoList) {
        eventsRepo.saveAll(dtoList.stream().map(EventsConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateEvents(EventsDto dto) {
        if (eventsRepo.existsById(dto.getId())) {
            eventsRepo.save(EventsConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteEventsById(long id) {
        eventsRepo.deleteById(id);
        return true;
    }
}
