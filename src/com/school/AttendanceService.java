package com.school;

public class AttendanceService {
    private RegistrationService registrationService;

    public AttendanceService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void markAttendance(String studentId, String courseId, boolean present) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null) {
            System.out.println("Student not found: " + studentId);
            return;
        }
        if (course == null) {
            System.out.println("Course not found: " + courseId);
            return;
        }
        if (!course.getEnrolledStudents().contains(student)) {
            System.out.println("Student " + studentId + " is not enrolled in " + course.getCourseName());
            return;
        }

        System.out.println("Attendance marked for " + studentId + " in " + course.getCourseName() + ": " + (present ? "Present" : "Absent"));
    }
}
