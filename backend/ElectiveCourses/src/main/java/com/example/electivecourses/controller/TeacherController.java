package com.example.electivecourses.controller;

import com.example.electivecourses.dto.teacher.CreateTeacherDto;
import com.example.electivecourses.dto.teacher.EditTeacherDto;
import com.example.electivecourses.dto.teacher.TeacherDto;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Teacher;
import com.example.electivecourses.mappers.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.electivecourses.service.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherService.findAllTeachers();
        List<TeacherDto> teachersDto = teachers.stream().map(t -> {
            TeacherDto teacherDto = teacherMapper.toTeacherDto(t);
            teacherDto.setCourseId(t.getCourse().getId());
            return teacherDto;
        }).collect(Collectors.toList());
        return teachersDto;
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Integer id) {
        Teacher teacher = teacherService.findTeacherById(id);
        TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);
        teacherDto.setCourseId(teacher.getCourse().getId());
        return teacherDto;
    }

    @PostMapping
    public TeacherDto createTeacher(@RequestBody CreateTeacherDto createTeacherDto) {
        Course course = new Course();
        course.setId(createTeacherDto.getCourseId());
        Teacher teacher = new Teacher(createTeacherDto.getName(), course);
        teacher = teacherService.saveTeacher(teacher);

        TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);
        teacherDto.setCourseId(teacher.getCourse().getId());
        return teacherDto;
    }

    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Integer id, @RequestBody EditTeacherDto editTeacherDto) {
        Teacher existingTeacher = teacherService.findTeacherById(id);
        if (existingTeacher != null) {
            Teacher teacher = teacherMapper.toTeacher(editTeacherDto);
            teacher.setId(id);
            teacher.setCourse(existingTeacher.getCourse());
            teacherService.saveTeacher(teacher);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
    }
}