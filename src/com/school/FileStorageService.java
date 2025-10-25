package com.school;

import java.io.*;
import java.util.*;

public class FileStorageService {
    public void saveCourses(List<Course> courses, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Course course : courses) {
                writer.write(course.toDataString());
                writer.newLine();
            }
            System.out.println("✅ Courses saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error saving courses: " + e.getMessage());
        }
    }
}
