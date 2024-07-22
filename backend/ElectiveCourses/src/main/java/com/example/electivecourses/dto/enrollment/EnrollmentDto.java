package com.example.electivecourses.dto.enrollment;

import com.example.electivecourses.entity.Student;

public class EnrollmentDto {
    private Integer id;
    private Student student;
    private Integer courseId;
    private Boolean status;
    private Integer createdAtYear;
    private Integer createdAtMonth;
    private Integer createdAtDay;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public Integer getId() {
        return id;
    }

    public Student getStudent() {
        return student;
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
