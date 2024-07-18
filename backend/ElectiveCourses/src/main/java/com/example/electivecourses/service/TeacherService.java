package com.example.electivecourses.service;

import com.example.electivecourses.entity.Teacher;
import com.example.electivecourses.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher findTeacherById(Long id) {
        return  teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> findTeachersByCourseId(Integer courseId) {
        return  teacherRepository.findAllByCourseId(courseId);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
