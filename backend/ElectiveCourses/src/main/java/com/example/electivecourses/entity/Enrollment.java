package com.example.electivecourses.entity;

import jakarta.persistence.*;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private Integer courseId;
    private Boolean status;
    private Integer createdAtYear;
    private Integer createdAtMonth;
    private Integer createdAtDay;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCreatedAtYear() {
        return createdAtYear;
    }

    public void setCreatedAtYear(Integer createdAtYear) {
        this.createdAtYear = createdAtYear;
    }

    public Integer getCreatedAtMonth() {
        return createdAtMonth;
    }

    public void setCreatedAtMonth(Integer createdAtMonth) {
        this.createdAtMonth = createdAtMonth;
    }

    public Integer getCreatedAtDay() {
        return createdAtDay;
    }

    public void setCreatedAtDay(Integer createdAtDay) {
        this.createdAtDay = createdAtDay;
    }
}
