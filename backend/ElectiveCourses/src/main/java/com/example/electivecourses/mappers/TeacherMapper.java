package com.example.electivecourses.mappers;

import com.example.electivecourses.dto.teacher.CreateTeacherDto;
import com.example.electivecourses.dto.teacher.EditTeacherDto;
import com.example.electivecourses.dto.teacher.TeacherDto;
import com.example.electivecourses.entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toTeacher(CreateTeacherDto createTeacherDto);
    Teacher toTeacher(EditTeacherDto editTeacherDto);
    CreateTeacherDto toCreateTeacherDto(Teacher course);
    EditTeacherDto toEditTeacherDto(Teacher course);
    TeacherDto toTeacherDto(Teacher course);
    Teacher toTeacher(TeacherDto courseDTO);
}
