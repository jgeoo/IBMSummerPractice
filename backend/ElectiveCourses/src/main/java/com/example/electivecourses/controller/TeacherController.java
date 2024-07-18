package com.example.electivecourses.controller;

import com.example.electivecourses.dto.teacher.CreateTeacherDto;
import com.example.electivecourses.dto.teacher.EditTeacherDto;
import com.example.electivecourses.dto.teacher.TeacherDto;
import com.example.electivecourses.entity.Teacher;
import com.example.electivecourses.mappers.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.electivecourses.service.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.findAllTeachers().stream()
                .map(teacherMapper::toTeacherDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Long id) {
        return teacherMapper.toTeacherDto(teacherService.findTeacherById(id));
    }

    @PostMapping
    public TeacherDto createTeacher(@RequestBody CreateTeacherDto createTeacherDto) {
        Teacher teacher = teacherMapper.toTeacher(createTeacherDto);
        teacher = teacherService.saveTeacher(teacher);
        return teacherMapper.toTeacherDto(teacher);
    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody EditTeacherDto editTeacherDto) {
        Teacher existingTeacher = teacherService.findTeacherById(id);
        if (existingTeacher != null) {
            Teacher teacher = teacherMapper.toTeacher(editTeacherDto);
            teacher.setId(id);
            teacherService.saveTeacher(teacher);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}