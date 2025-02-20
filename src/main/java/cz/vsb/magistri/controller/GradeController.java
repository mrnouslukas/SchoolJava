package cz.vsb.magistri.controller;

import cz.vsb.magistri.dto.GradeDto;
import cz.vsb.magistri.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    public List<GradeDto> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/grades/{gradeId}")
    public GradeDto getGrade(@PathVariable long gradeId) {
        return gradeService.getGrade(gradeId);
    }

    @PostMapping("/grades")
    public GradeDto addGrade(GradeDto gradeDto) {
        return gradeService.addGrade(gradeDto);
    }

    @PutMapping("/grades/{gradeId}")
    public GradeDto editGrade(@PathVariable long gradeId, @RequestBody GradeDto gradeDto) {
        return gradeService.editGrade(gradeDto, gradeId);
    }

    @DeleteMapping("/grades/{gradeId}")
    public GradeDto deleteGrade(@PathVariable long gradeId) {
        return gradeService.deleteGrade(gradeId);
    }
}
