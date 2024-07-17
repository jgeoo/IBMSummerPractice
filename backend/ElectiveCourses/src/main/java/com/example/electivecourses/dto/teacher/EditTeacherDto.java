package com.example.electivecourses.dto.teacher;


public class EditTeacherDto {
    private String name;
    private Long courseId; // Assuming courseId for referencing Course

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
