package com.usercard.user.controllers;

import com.usercard.user.dtos.EventDto;
import com.usercard.user.dtos.GroupDto;
import com.usercard.user.services.EventService;
import com.usercard.user.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/group")
@CrossOrigin(origins = "http://localhost:3000")
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/get-group")
    public List<GroupDto> getGroup() {
        return groupService.showAllGroups();
    }

    @PostMapping("/get-group-by-id")
    public GroupDto showGroupDto(@RequestParam long id) {
        return groupService.showGroupsDto(id);
    }

    @PostMapping("/save-all-group")
    public boolean saveEvent(@RequestBody List<GroupDto> dto) {
        return groupService.addGroupsList(dto);
    }

    @PutMapping("/update-group")
    public boolean updateGroup(@RequestBody GroupDto dto) {
        return groupService.updateGroups(dto);
    }

    @DeleteMapping("/delete-group-by-id")
    public boolean deleteGroupById(@RequestParam long id) {
        return groupService.deleteGroupsById(id);
    }
}
