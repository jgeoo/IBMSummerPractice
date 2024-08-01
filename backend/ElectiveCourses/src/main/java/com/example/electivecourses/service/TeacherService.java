package com.example.electivecourses.service;

import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Teacher;
import com.example.electivecourses.repository.TeacherRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher findTeacherById(Integer id) {
        return  teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> findTeachersByCourseId(Integer courseId) {
        return  teacherRepository.findAllByCourseId(courseId);
    }

    public Teacher saveTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        Teacher newTeacher = teacherRepository.findById(savedTeacher.getId()).orElse(null);
        return newTeacher;
    }

    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }
}