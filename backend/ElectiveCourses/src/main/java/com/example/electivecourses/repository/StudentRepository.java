package com.example.electivecourses.repository;

import com.example.electivecourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);


}
