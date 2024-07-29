package com.example.electivecourses.controller;

import com.example.electivecourses.dto.course.CourseDto;
import com.example.electivecourses.dto.course.CreateCourseDto;
import com.example.electivecourses.dto.course.EditCourseDto;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.electivecourses.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        // DE MUTAT MAPARE IN SERVICEURI
        return courseService.findAllCourses();
    }
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        return courseService.findCourseById(id);
    }

    @PostMapping
    public CourseDto createCourse(@RequestBody CreateCourseDto createCourseDto) {
        return courseService.createCourse(createCourseDto);
    }

    @PutMapping("/{id}")
    public CourseDto updateCourse(@PathVariable Integer id, @RequestBody EditCourseDto editCourseDto) {
        return courseService.updateCourse(id, editCourseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }
}