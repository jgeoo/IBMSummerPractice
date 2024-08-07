package com.example.electivecourses.service;

import com.example.electivecourses.dto.enrollment.CreateEnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto;
import com.example.electivecourses.dto.enrollment.EnrollmentDto2;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Enrollment;
import com.example.electivecourses.entity.Student;
import com.example.electivecourses.mappers.EnrollmentMapper;
import com.example.electivecourses.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

//    public List<EnrollmentDto> findAllEnrollments() {
//        return enrollmentRepository.findAll().stream()
//                .map(enrollment -> {
//                    EnrollmentDto enrollmentDto = enrollmentMapper.toEnrollmentDto(enrollment);
//                    enrollmentDto.setCourseId(enrollment.getCourse().getId());
//                    enrollmentDto.setStudentId(enrollment.getStudent().getId());
//                    return enrollmentDto;
//                })
//                .collect(Collectors.toList());
//    }

        public List<EnrollmentDto2> findAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollment -> {
                    EnrollmentDto2 enrollmentDto = new EnrollmentDto2();
                    enrollmentDto.setCourseName(enrollment.getCourse().getName());
                    enrollmentDto.setStudentName(enrollment.getStudent().getName());
                    enrollmentDto.setCourseMaxStudents(enrollment.getCourse().getMaxStudentsAllowed());
                    enrollmentDto.setStudentGrade(enrollment.getStudent().getGrade());
                    return enrollmentDto;
                })
                .collect(Collectors.toList());
    }

    public EnrollmentDto findEnrollmentById(Integer id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
        if (enrollment != null) {
            EnrollmentDto enrollmentDto = enrollmentMapper.toEnrollmentDto(enrollment);
            enrollmentDto.setCourseId(enrollment.getCourse().getId());
            enrollmentDto.setStudentId(enrollment.getStudent().getId());
            return enrollmentDto;
        }
        return null;
    }

    public EnrollmentDto saveEnrollment(CreateEnrollmentDto createEnrollmentDto) {
        Enrollment enrollment = enrollmentMapper.toEnrollment(createEnrollmentDto);
        Course course = new Course();
        course.setId(createEnrollmentDto.getCourseId());
        Student student = new Student();
        student.setId(createEnrollmentDto.getStudentId());
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment = enrollmentRepository.save(enrollment);
        EnrollmentDto enrollmentDto = enrollmentMapper.toEnrollmentDto(enrollment);
        enrollmentDto.setCourseId(enrollment.getCourse().getId());
        enrollmentDto.setStudentId(enrollment.getStudent().getId());
        return enrollmentDto;
    }

    public void deleteEnrollment(Integer id) {
        enrollmentRepository.deleteById(id);
    }
}
