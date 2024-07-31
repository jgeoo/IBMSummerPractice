package com.example.electivecourses.service;

import com.example.electivecourses.dto.student.CreateStudentDto;
import com.example.electivecourses.dto.student.StudentDto;
import com.example.electivecourses.entity.Student;
import com.example.electivecourses.mappers.StudentMapper;
import com.example.electivecourses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository studentRepository;

    public StudentDto getByName(String name) {
        Student student = studentRepository.findByName(name);
        return studentMapper.toStudentDto(student);
    }

    public StudentDto saveStudent(CreateStudentDto createStudentDto) {
        Student student = studentMapper.toStudent(createStudentDto);
        student = studentRepository.save(student);
        return studentMapper.toStudentDto(student);
    }
}