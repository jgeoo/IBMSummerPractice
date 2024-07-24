package com.example.electivecourses.dto.enrollment;

import com.example.electivecourses.entity.Student;

public class CreateEnrollmentDto {
    private Integer studentId;
    private Integer courseId;
    private Integer status;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
