package com.example.electivecourses.repository;

import com.example.electivecourses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByName(String name);

    List<Teacher> findAllByCourseId(Integer id);
}

