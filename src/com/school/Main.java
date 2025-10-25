package com.school;

public class Main {
    public static void main(String[] args) {
        RegistrationService regService = new RegistrationService();
        AttendanceService attendanceService = new AttendanceService(regService);

        // Create courses
        Course javaCourse = regService.createCourse("C101", "Java Programming", "Dr. Smith", 2);
        Course pythonCourse = regService.createCourse("C102", "Python Programming", "Dr. John", 1);

        // Register students
        Student s1 = new Student("Alice", "A");
        Student s2 = new Student("Bob", "B");
        Student s3 = new Student("Charlie", "C");

        regService.registerStudent(s1);
        regService.registerStudent(s2);
        regService.registerStudent(s3);

        // Enroll students
        regService.enrollStudentInCourse(s1, javaCourse);
        regService.enrollStudentInCourse(s2, javaCourse);
        regService.enrollStudentInCourse(s3, javaCourse); // Should fail

        // Display course details
        for (Course c : regService.getCourses()) {
            c.displayDetails();
        }

        // Mark attendance
        attendanceService.markAttendance(s1.getId(), javaCourse.getCourseId(), true);
        attendanceService.markAttendance(s3.getId(), javaCourse.getCourseId(), true); // Not enrolled
    }
}
