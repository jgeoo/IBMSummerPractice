package com.example.electivecourses.dto.course;


public class CourseDto {
    private Long id;
    private Integer maxStudentsAllowed;
    private Integer yearOfStudy;
    private String category;
    private String dayOfWeek;
    private Integer startHour;
    private Integer endHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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