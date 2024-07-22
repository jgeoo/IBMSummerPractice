package com.example.electivecourses.repository;

import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Enrollment;
import com.example.electivecourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findEnrollmentsByStudent(Student student);
}
