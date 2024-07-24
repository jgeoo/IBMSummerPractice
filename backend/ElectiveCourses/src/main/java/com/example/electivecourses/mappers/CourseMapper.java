package com.example.electivecourses.mappers;

import com.example.electivecourses.dto.course.CourseDto;
import com.example.electivecourses.dto.course.CreateCourseDto;
import com.example.electivecourses.dto.course.EditCourseDto;
import com.example.electivecourses.dto.teacher.TeacherDto;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TeacherMapper.class)
public interface CourseMapper {

    Course toCourse(CreateCourseDto createCourseDto);

    Course toCourse(EditCourseDto editCourseDto);

    CourseDto toCourseDto(Course course);


}