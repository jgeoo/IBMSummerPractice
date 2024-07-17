package com.example.electivecourses.mappers;

import com.example.electivecourses.dto.course.CourseDto;
import com.example.electivecourses.dto.course.CreateCourseDto;
import com.example.electivecourses.dto.course.EditCourseDto;
import com.example.electivecourses.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CreateCourseDto createCourseDto);
    Course toCourse(EditCourseDto editCourseDto);
    CreateCourseDto toCreateCourseDto(Course course);
    EditCourseDto toEditCourseDto(Course course);
    CourseDto toCourseDto(Course course);
    Course toCourse(CourseDto courseDTO);
}