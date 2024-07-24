package com.example.electivecourses.dto.teacher;


public class EditTeacherDto {
    private String name;
    private Integer courseId; // Assuming courseId for referencing Course

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
