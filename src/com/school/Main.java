package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course();
        c1.setDetails(1, "DBMS");

        Course c2 = new Course();
        c2.setDetails(2, "LHT");

        Student student1 = new Student("Pratham", "10th Grade");
        student1.id = 11;

        Student student2 = new Student("Krish", "12th Grade");
        student2.id = 12;

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);

        AttendanceRecord record1 = new AttendanceRecord(11, 1, "Present");
        AttendanceRecord record2 = new AttendanceRecord(12, 2, "Absent");

        List<AttendanceRecord> records = new ArrayList<>();
        records.add(record1);
        records.add(record2);

        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");

        System.out.println("Data has been stored successfully.");
    }
}
