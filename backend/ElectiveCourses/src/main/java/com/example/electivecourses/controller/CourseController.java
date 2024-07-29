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

    @Autowired
    private CourseMapper courseMapper;


    @GetMapping
    public List<CourseDto> getAllCourses() {
        // DE MUTAT MAPARE IN SERVICEURI
        return courseService.findAllCourses().stream()
                .map(courseMapper::toCourseDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        return courseMapper.toCourseDto(courseService.findCourseById(id));
    }

    @PostMapping
    public CourseDto createCourse(@RequestBody CreateCourseDto createCourseDto) {
        // DE MUTAT MAPARE IN SERVICEURI
        Course course = courseMapper.toCourse(createCourseDto);
        course = courseService.saveCourse(course);
        return courseMapper.toCourseDto(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Integer id, @RequestBody EditCourseDto editCourseDto) {
        Course existingCourse = courseService.findCourseById(id);
        if (existingCourse != null) {
            Course course = courseMapper.toCourse(editCourseDto);
            course.setId(id); // ?
            courseService.saveCourse(course);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }
}