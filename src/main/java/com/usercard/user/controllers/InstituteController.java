package com.usercard.user.controllers;

import com.usercard.user.dtos.GroupDto;
import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.services.GroupService;
import com.usercard.user.services.InstituteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/institute")
@CrossOrigin(origins = "http://localhost:3000")
public class InstituteController {
    private final InstituteService instituteService;

    @GetMapping("/get-institute")
    public List<InstituteDto> getInstitute() {
        return instituteService.showAllInstitutes();
    }

    @PostMapping("/get-institute-by-id")
    public InstituteDto showInstituteDto(@RequestParam long id) {
        return instituteService.showInstitutesDto(id);
    }

    @PostMapping("/save-all-institute")
    public boolean saveInstitute(@RequestBody List<InstituteDto> dto) {
        return instituteService.addInstitutesList(dto);
    }

    @PutMapping("/update-institute")
    public boolean updateInstitute(@RequestBody InstituteDto dto) {
        return instituteService.updateInstitutes(dto);
    }

    @DeleteMapping("/delete-institute-by-id")
    public boolean deleteInstituteById(@RequestParam long id) {
        return instituteService.deleteInstitutesById(id);
    }
}
