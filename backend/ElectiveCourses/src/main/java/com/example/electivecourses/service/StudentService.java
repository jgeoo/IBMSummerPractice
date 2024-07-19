package com.example.electivecourses.service;


import com.example.electivecourses.entity.Student;
import com.example.electivecourses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student getbyname(String name) {
        return studentRepository.findByName(name);
    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
