package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private String courseId;
    private String courseName;
    private String instructor;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseId, String courseName, String instructor, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public int getCapacity() { return capacity; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getNumberOfEnrolledStudents() { return enrolledStudents.size(); }

    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Capacity: " + capacity);
        System.out.println("Currently Enrolled: " + enrolledStudents.size());
        System.out.println("-----------------------------");
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName + "," + instructor + "," + capacity;
    }

    public static Course fromDataString(String data) {
        String[] parts = data.split(",");
        if (parts.length < 4) throw new IllegalArgumentException("Invalid data: " + data);
        return new Course(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
    }
}
