package cz.vsb.magistri.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Long> gradeIds;
}
