package com.example.electivecourses.mappers;


import com.example.electivecourses.dto.student.CreateStudentDto;
import com.example.electivecourses.dto.student.EditStudentDto;
import com.example.electivecourses.dto.student.StudentDto;
import com.example.electivecourses.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(CreateStudentDto createStudentDto);
    Student toStudent(EditStudentDto editStudentDto);
    StudentDto toStudentDto(Student student);
    EditStudentDto toEditStudentDto(Student student);

}
