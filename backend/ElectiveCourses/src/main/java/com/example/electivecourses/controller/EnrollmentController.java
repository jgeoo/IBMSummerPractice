package com.example.electivecourses.controller;

import com.example.electivecourses.dto.enrollment.CreateEnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto2;
import com.example.electivecourses.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentDto2> getAllEnrollments() {
        return enrollmentService.findAllEnrollments();
    }

    @GetMapping("/{id}")
    public EnrollmentDto getEnrollmentById(@PathVariable Integer id) {
        return enrollmentService.findEnrollmentById(id);
    }

    @PostMapping
    public EnrollmentDto createEnrollment(@RequestBody CreateEnrollmentDto createEnrollmentDto) {
        return enrollmentService.saveEnrollment(createEnrollmentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
    }
}
