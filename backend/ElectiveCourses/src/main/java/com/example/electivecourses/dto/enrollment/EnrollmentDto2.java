package com.example.electivecourses.dto.enrollment;

public class EnrollmentDto2 {
    private String studentName;
    private String courseName;
    private Integer courseMaxStudents;
    private Integer studentGrade;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseMaxStudents() {
        return courseMaxStudents;
    }

    public void setCourseMaxStudents(Integer courseMaxStudents) {
        this.courseMaxStudents = courseMaxStudents;
    }

    public Integer getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Integer studentGrade) {
        this.studentGrade = studentGrade;
    }
}
