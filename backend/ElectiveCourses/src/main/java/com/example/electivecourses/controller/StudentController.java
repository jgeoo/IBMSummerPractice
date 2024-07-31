package com.example.electivecourses.controller;

import com.example.electivecourses.dto.student.CreateStudentDto;
import com.example.electivecourses.dto.student.StudentDto;
import com.example.electivecourses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{name}")
    public StudentDto getStudentByName(@PathVariable String name) {
        return studentService.getByName(name);
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody CreateStudentDto createStudentDto) {
        return studentService.saveStudent(createStudentDto);
    }
}