package cz.vsb.magistri.service;

import cz.vsb.magistri.dto.StudentDto;
import cz.vsb.magistri.entity.StudentEntity;
import cz.vsb.magistri.mapper.StudentMapper;
import cz.vsb.magistri.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
//        StudentDto studentDto = studentMapper.toDto(studentEntity);
//        studentDtos.add(studentDto);

            studentDtos.add(studentMapper.toDto(studentEntity));
        }
        return studentDtos;
    }

    public StudentDto getStudent(int id){
        return studentMapper.toDto(studentRepository.getReferenceById(id));
    }

    public StudentDto addStudent(StudentDto studentDto){
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedEntity);
    }

    public StudentDto editStudent(int studentId, StudentDto editedStudent){
        if (!studentRepository.existsById(studentId)){
            throw new EntityNotFoundException("Student with id " + studentId + " does not exist");
        }
        StudentEntity studentEntity = studentMapper.toEntity(editedStudent);
        studentEntity.setId(studentId);
        StudentEntity savedStudent = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedStudent);
    }
    public StudentDto deleteStudent(int studentId){
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
        StudentDto deletedStudent = studentMapper.toDto(studentEntity);
        studentRepository.delete(studentEntity);
        return deletedStudent;
    }
}

