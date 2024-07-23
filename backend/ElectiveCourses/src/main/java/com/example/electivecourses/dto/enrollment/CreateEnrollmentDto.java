package com.example.electivecourses.dto.enrollment;

import com.example.electivecourses.entity.Student;

public class CreateEnrollmentDto {
    private Integer studentId;
    private Integer courseId;
    private Boolean status;
    private Integer createdAtYear;
    private Integer createdAtMonth;
    private Integer createdAtDay;


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setCreatedAtYear(Integer createdAtYear) {
        this.createdAtYear = createdAtYear;
    }

    public void setCreatedAtMonth(Integer createdAtMonth) {
        this.createdAtMonth = createdAtMonth;
    }

    public void setCreatedAtDay(Integer createdAtDay) {
        this.createdAtDay = createdAtDay;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getCreatedAtYear() {
        return createdAtYear;
    }

    public Integer getCreatedAtMonth() {
        return createdAtMonth;
    }

    public Integer getCreatedAtDay() {
        return createdAtDay;
    }
}
