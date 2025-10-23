package com.school;

public class Course implements Storable {
    private static int counter = 101;
    private int courseId;
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
        this.courseId = counter++;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }

    @Override
    public String toString() { return courseId + "," + courseName; }

    @Override
    public String toDataString() { return courseId + "," + courseName; }

    public static Course fromDataString(String line) {
        String[] parts = line.split(",");
        Course c = new Course(parts[1]);
        try {
            java.lang.reflect.Field field = Course.class.getDeclaredField("courseId");
            field.setAccessible(true);
            field.set(c, Integer.parseInt(parts[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
