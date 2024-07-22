package com.example.electivecourses.controller;

import com.example.electivecourses.dto.enrollment.CreateEnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto;
import com.example.electivecourses.entity.Enrollment;
import com.example.electivecourses.mappers.EnrollmentMapper;
import com.example.electivecourses.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @GetMapping
    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentService.findAllEnrollments().stream()
                .map(enrollmentMapper::toEnrollmentDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EnrollmentDto getEnrollmentById(@PathVariable Integer id) {
        return enrollmentMapper.toEnrollmentDto(enrollmentService.findEnrollmentById(id));
    }

    @PostMapping
    public EnrollmentDto createEnrollment(@RequestBody CreateEnrollmentDto createEnrollmentDto) {
        Enrollment enrollment = enrollmentMapper.toEnrollment(createEnrollmentDto);
        enrollment = enrollmentService.saveEnrollment(enrollment);
        return enrollmentMapper.toEnrollmentDto(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
    }
}