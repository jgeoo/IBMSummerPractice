package com.example.electivecourses.dto.course;


public class CourseDto {
    private Integer id;
    private String name;
    private Integer maxStudentsAllowed;
    private Integer yearOfStudy;
    private String dayOfWeek;
    private Integer startHour;
    private Integer endHour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxStudentsAllowed() {
        return maxStudentsAllowed;
    }

    public void setMaxStudentsAllowed(Integer maxStudentsAllowed) {
        this.maxStudentsAllowed = maxStudentsAllowed;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
}