package com.example.electivecourses.service;

import com.example.electivecourses.entity.Enrollment;
import com.example.electivecourses.entity.Student;
import com.example.electivecourses.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> findAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment findEnrollmentById(Integer id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public List<Enrollment> findEnrollmentsByStudent(Student student) {
        return enrollmentRepository.findEnrollmentsByStudent(student);
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Integer id) {
        enrollmentRepository.deleteById(id);
    }
}
