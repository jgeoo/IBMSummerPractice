package com.example.electivecourses.mappers;

import com.example.electivecourses.dto.enrollment.CreateEnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto;
import com.example.electivecourses.entity.Enrollment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    Enrollment toEnrollment(CreateEnrollmentDto createEnrollmentDto);
    EnrollmentDto toEnrollmentDto(Enrollment enrollment);
    Enrollment toEnrollment(EnrollmentDto enrollmentDTO);
}