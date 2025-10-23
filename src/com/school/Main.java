package com.school;

import java.util.*;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        for (Person p : people) p.displayDetails();
    }

    public static void main(String[] args) {
        FileStorageService storageService = new FileStorageService();
        RegistrationService regService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, regService);

        // Register students
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 9");
        regService.registerStudent(s1);
        regService.registerStudent(s2);

        // Register teacher
        Teacher t1 = new Teacher("Dr. Smith", "Math");
        regService.registerTeacher(t1);

        // Register staff
        Staff st1 = new Staff("Mr. John", "Librarian");
        regService.registerStaff(st1);

        // Create course
        Course c1 = new Course("Algebra");
        regService.createCourse(c1);

        displaySchoolDirectory(regService.getAllPeople());

        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");
        attendanceService.displayAttendanceLog();

        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
