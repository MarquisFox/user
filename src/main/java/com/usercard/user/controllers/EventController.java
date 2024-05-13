package com.usercard.user.controllers;

import com.usercard.user.dtos.CategoryDto;
import com.usercard.user.dtos.EventDto;
import com.usercard.user.services.CategoryService;
import com.usercard.user.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
    private final EventService eventService;

    @GetMapping("/get-event")
    public List<EventDto> getEvent() {
        return eventService.showAllEvents();
    }

    @PostMapping("/get-event-by-id")
    public EventDto showEventDto(@RequestParam long id) {
        return eventService.showEventsDto(id);
    }

    @PostMapping("/save-all-event")
    public boolean saveEvent(@RequestBody List<EventDto> dto) {
        return eventService.addEventsList(dto);
    }

    @PutMapping("/update-event")
    public boolean updateEvent(@RequestBody EventDto dto) {
        return eventService.updateEvents(dto);
    }

    @DeleteMapping("/delete-event-by-id")
    public boolean deleteEventById(@RequestParam long id) {
        return eventService.deleteEventsById(id);
    }
}
