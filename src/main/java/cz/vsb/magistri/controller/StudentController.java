package cz.vsb.magistri.controller;

import cz.vsb.magistri.dto.StudentDto;
import cz.vsb.magistri.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    //    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @GetMapping({"/students", "/students/"})
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public StudentDto getStudent(@PathVariable int studentId){
        return studentService.getStudent(studentId);
    }


    @PostMapping({"/students", "/students/"})
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @PutMapping("/students/{studentId}")
    public StudentDto editStudent(@PathVariable int studentId, @RequestBody StudentDto studentDto){
        return studentService.editStudent(studentId, studentDto);
    }

    @DeleteMapping("/students/{studentId}")
    public StudentDto deleteStudent(@PathVariable int studentId){
        return studentService.deleteStudent(studentId);
    }
}
