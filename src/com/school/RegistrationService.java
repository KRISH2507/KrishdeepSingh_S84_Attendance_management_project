package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Course createCourse(String courseId, String courseName, String instructor, int capacity) {
        Course course = new Course(courseId, courseName, instructor, capacity);
        courses.add(course);
        return course;
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println(student.getId() + " enrolled in " + course.getCourseName());
        } else {
            System.out.println("Course full! Cannot enroll " + student.getId() + " in " + course.getCourseName());
        }
        return success;
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    public Course findCourseById(String id) {
        for (Course c : courses) {
            if (c.getCourseId().equals(id)) return c;
        }
        return null;
    }

    public List<Course> getCourses() { return courses; }
    public List<Student> getStudents() { return students; }
}
