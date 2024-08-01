package com.example.electivecourses.service;

import com.example.electivecourses.dto.course.CourseDto;
import com.example.electivecourses.dto.course.CreateCourseDto;
import com.example.electivecourses.dto.course.EditCourseDto;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Teacher;
import com.example.electivecourses.mappers.CourseMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.electivecourses.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherService teacherService;
    public List<CourseDto> findAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toCourseDto)
                .collect(Collectors.toList());
    }

    public CourseDto findCourseById(Integer id) {
        return courseMapper.toCourseDto(courseRepository.findById(id).orElse(null));
    }

    public CourseDto updateCourse(Integer id, EditCourseDto courseDto) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            Course course = courseMapper.toCourse(courseDto);
            course.setId(id);
            return courseMapper.toCourseDto(courseRepository.save(course));
        }
        else
            return null;
    }

    public CourseDto createCourse(CreateCourseDto createCourseDto) {
        Course course = courseMapper.toCourse(createCourseDto);
        course.setMaxStudentsAllowed(createCourseDto.getMaxStudentsAllowed());
        Course savedCourse = courseRepository.save(course);

        CourseDto courseDto = courseMapper.toCourseDto(savedCourse);
        return courseDto;
    }


    @Transactional
    public void deleteCourse(Integer id) {
        List<Teacher> teachers = teacherService.findTeachersByCourseId(id);
        for (Teacher teacher : teachers) {
            teacherService.deleteTeacher(teacher.getId());
        }
        courseRepository.deleteById(id);
    }
}
