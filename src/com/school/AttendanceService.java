package com.school;

import java.util.*;

public class AttendanceService {
    private FileStorageService storageService;
    private RegistrationService registrationService;
    private List<String> attendanceLog = new ArrayList<>();

    public AttendanceService(FileStorageService storageService, RegistrationService regService) {
        this.storageService = storageService;
        this.registrationService = regService;
    }

    public void markAttendance(Student s, Course c, String status) {
        attendanceLog.add(s.getName() + " - " + c.getCourseName() + " - " + status);
    }

    public void markAttendance(int studentId, int courseId, String status) {
        Student s = registrationService.findStudentById(studentId);
        Course c = registrationService.findCourseById(courseId);
        if (s != null && c != null) markAttendance(s, c, status);
    }

    public void displayAttendanceLog() {
        System.out.println("\n--- Attendance Log ---");
        for (String entry : attendanceLog) {
            System.out.println(entry);
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(new ArrayList<>(attendanceLog.stream().map(s -> (Storable) () -> s).toList()), "attendance_log.txt");
    }
}
