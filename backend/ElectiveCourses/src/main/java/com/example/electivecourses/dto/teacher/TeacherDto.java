package com.example.electivecourses.dto.teacher;

import com.example.electivecourses.dto.course.CourseDto;

public class TeacherDto {
    private Integer id;
    private String name;
    private Integer courseId; // Assuming courseId for referencing Course

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
