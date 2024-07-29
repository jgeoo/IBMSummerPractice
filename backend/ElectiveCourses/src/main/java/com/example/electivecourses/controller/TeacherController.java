package com.example.electivecourses.controller;

import com.example.electivecourses.dto.teacher.CreateTeacherDto;
import com.example.electivecourses.dto.teacher.EditTeacherDto;
import com.example.electivecourses.dto.teacher.TeacherDto;
import com.example.electivecourses.mappers.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.electivecourses.service.TeacherService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Integer id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public TeacherDto createTeacher(@RequestBody CreateTeacherDto createTeacherDto) {
        return teacherService.createTeacher(createTeacherDto);
    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Integer id, @RequestBody EditTeacherDto editTeacherDto) {
        teacherService.updateTeacher(id, editTeacherDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
    }
}
