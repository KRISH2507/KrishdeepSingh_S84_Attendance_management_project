package com.school;

public class Course implements Storable {
    private int courseId;
    private String courseName;

    public void setDetails(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + this.courseId + ", Course Name: " + this.courseName);
    }

    @Override
    public String toDataString() {
        return this.courseId + "," + this.courseName;
    }
}
