package cz.vsb.magistri.mapper;

import cz.vsb.magistri.dto.StudentDto;
import cz.vsb.magistri.entity.GradeEntity;
import cz.vsb.magistri.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.ArrayList;
import java.util.List;

//@Mapper(componentModel = "spring")
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    StudentEntity toEntity(StudentDto source);
    @Mapping(target = "gradeIds", expression = "java(getGradeIds(source))")
    StudentDto toDto(StudentEntity source);

    default List<Long> getGradeIds(StudentEntity source){
        List<Long> gradeIds = new ArrayList<>();
        if (source.getGrades()!=null){
            for (GradeEntity grade : source.getGrades()) {
                gradeIds.add(grade.getId());
            }
        }
        return gradeIds;
    }
}
