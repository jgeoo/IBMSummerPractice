package com.example.electivecourses.controller;

import com.example.electivecourses.dto.student.CreateStudentDto;
import com.example.electivecourses.dto.student.StudentDto;
import com.example.electivecourses.entity.Student;
import com.example.electivecourses.mappers.StudentMapper;
import com.example.electivecourses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/{name}")
    public StudentDto getStudentByName(@PathVariable String name) {
        return studentMapper.toStudentDto(studentService.getbyname(name));
    }

    @PostMapping
    public void createStudent(@RequestBody CreateStudentDto createStudentDto) {
        Student student = studentMapper.toStudent(createStudentDto);
        student = studentService.saveStudent(student);

    }
}
