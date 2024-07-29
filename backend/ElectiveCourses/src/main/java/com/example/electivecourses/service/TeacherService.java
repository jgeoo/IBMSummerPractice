package com.example.electivecourses.service;

import com.example.electivecourses.dto.teacher.CreateTeacherDto;
import com.example.electivecourses.dto.teacher.EditTeacherDto;
import com.example.electivecourses.dto.teacher.TeacherDto;
import com.example.electivecourses.entity.Course;
import com.example.electivecourses.entity.Teacher;
import com.example.electivecourses.mappers.TeacherMapper;
import com.example.electivecourses.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(t -> {
            TeacherDto teacherDto = teacherMapper.toTeacherDto(t);
            teacherDto.setCourseId(t.getCourse().getId());
            return teacherDto;
        }).collect(Collectors.toList());
    }

    public TeacherDto getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);
            teacherDto.setCourseId(teacher.getCourse().getId());
            return teacherDto;
        }
        return null;
    }

    public TeacherDto createTeacher(CreateTeacherDto createTeacherDto) {
        Course course = new Course();
        course.setId(createTeacherDto.getCourseId());
        Teacher teacher = new Teacher(createTeacherDto.getName(), course);
        teacher = teacherRepository.save(teacher);

        TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);
        teacherDto.setCourseId(teacher.getCourse().getId());
        return teacherDto;
    }

    public void updateTeacher(Integer id, EditTeacherDto editTeacherDto) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            Teacher teacher = teacherMapper.toTeacher(editTeacherDto);
            teacher.setId(id);
            teacher.setCourse(existingTeacher.getCourse());
            teacherRepository.save(teacher);
        }
    }

    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }
}
