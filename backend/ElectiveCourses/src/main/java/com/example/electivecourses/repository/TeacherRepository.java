package com.example.electivecourses.repository;

import com.example.electivecourses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByName(String name);

}

