package cz.vsb.magistri.mapper;

import cz.vsb.magistri.dto.GradeDto;
import cz.vsb.magistri.entity.GradeEntity;
import cz.vsb.magistri.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface GradeMapper {
    GradeEntity toEntity(GradeDto source);
    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "studentId", source = "student.id")

    GradeDto toDto(GradeEntity source);
    GradeEntity updateEntity(GradeDto source, @MappingTarget GradeEntity target);


}
