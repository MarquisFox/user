package com.usercard.user.controllers;

import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.dtos.PersonDto;
import com.usercard.user.services.InstituteService;
import com.usercard.user.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/get-person")
    public List<PersonDto> getPerson() {
        return personService.showAllPersons();
    }

    @PostMapping("/get-person-by-id")
    public PersonDto showPersonDto(@RequestParam long id) {
        return personService.showPersonsDto(id);
    }

    @PostMapping("/save-all-person")
    public boolean savePerson(@RequestBody List<PersonDto> dto) {
        return personService.addPersonsList(dto);
    }

    @PutMapping("/update-person")
    public boolean updatePerson(@RequestBody PersonDto dto) {
        return personService.updatePersons(dto);
    }

    @DeleteMapping("/delete-person-by-id")
    public boolean deletePersonById(@RequestParam long id) {
        return personService.deletePersonsById(id);
    }

    @PostMapping("/find-by-filter")
    public PersonDto findPersonByFilter(@RequestParam String groupName, @RequestParam String instituteName){
        return personService.findPersonByFilter(groupName,instituteName);
    }
}
