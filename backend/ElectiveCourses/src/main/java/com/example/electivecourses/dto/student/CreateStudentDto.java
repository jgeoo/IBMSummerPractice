package com.example.electivecourses.dto.student;

public class CreateStudentDto {
    private String name;
    private Integer grade;
    private Integer study_year;
    private String faculty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getStudy_year() {
        return study_year;
    }

    public void setStudy_year(Integer study_year) {
        this.study_year = study_year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
