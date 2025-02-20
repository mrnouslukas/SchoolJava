package cz.vsb.magistri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {
    private long id;
    //pro kontrolu
    private StudentDto student;
    private SubjectDto subject;
    //pro nalezeni studenta a predmetu skrz repozitar
    private int studentId;
    private int subjectId;
    private int mark;
    private String topic;

}
