package com.example.electivecourses.controller;

import com.example.electivecourses.dto.enrollment.CreateEnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Enrollment;
import com.example.electivecourses.entity.Student;
import com.example.electivecourses.mappers.EnrollmentMapper;
import com.example.electivecourses.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @GetMapping
    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentService.findAllEnrollments().stream()
                .map(e -> {
                    EnrollmentDto enrollmentDto = enrollmentMapper.toEnrollmentDto(e);
                    enrollmentDto.setCourseId(e.getCourse().getId());
                    enrollmentDto.setStudentId(e.getStudent().getId());
                    return enrollmentDto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EnrollmentDto getEnrollmentById(@PathVariable Integer id) {
        Enrollment enrollment = enrollmentService.findEnrollmentById(id);
        EnrollmentDto enrollmentDto = enrollmentMapper.toEnrollmentDto(enrollment);
        enrollmentDto.setCourseId(enrollment.getCourse().getId());
        enrollmentDto.setStudentId(enrollment.getStudent().getId());
        return enrollmentDto;
    }

    @PostMapping
    public EnrollmentDto createEnrollment(@RequestBody CreateEnrollmentDto createEnrollmentDto) {
        Enrollment enrollment = enrollmentMapper.toEnrollment(createEnrollmentDto);
        Course course = new Course();
        course.setId(createEnrollmentDto.getCourseId());
        Student student = new Student();
        student.setId(createEnrollmentDto.getStudentId());
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment = enrollmentService.saveEnrollment(enrollment);
        EnrollmentDto enrollmentDto = enrollmentMapper.toEnrollmentDto(enrollment);
        enrollmentDto.setCourseId(enrollment.getCourse().getId());
        enrollmentDto.setStudentId(enrollment.getStudent().getId());
        return enrollmentDto;
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
    }
}