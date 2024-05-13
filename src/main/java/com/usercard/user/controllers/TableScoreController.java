package com.usercard.user.controllers;

import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.dtos.TableScoreDto;
import com.usercard.user.services.InstituteService;
import com.usercard.user.services.TableScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/table_score")
@CrossOrigin(origins = "http://localhost:3000")
public class TableScoreController {
    private final TableScoreService tableScoreService;

    @GetMapping("/get-table-score")
    public List<TableScoreDto> getTableScore() {
        return tableScoreService.showAllTableScores();
    }

    @PostMapping("/get-table-score-by-id")
    public TableScoreDto showTableScoreDto(@RequestParam long id) {
        return tableScoreService.showTableScoresDto(id);
    }

    @PostMapping("/save-all-table-score")
    public boolean saveTableScore(@RequestBody List<TableScoreDto> dto) {
        return tableScoreService.addTableScoresList(dto);
    }

    @PutMapping("/update-table-score")
    public boolean updateTableScore(@RequestBody TableScoreDto dto) {
        return tableScoreService.updateTableScores(dto);
    }

    @DeleteMapping("/delete-table-score-by-id")
    public boolean deleteTableScoreById(@RequestParam long id) {
        return tableScoreService.deleteTableScoresById(id);
    }
}
