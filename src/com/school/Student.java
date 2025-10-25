package com.school;

public class Student extends Person implements Storable {
    private String grade;

    public Student(String name, String grade) {
        super(name);
        this.grade = grade;
    }

    public Student(String id, String name, String grade) {
        super(id, name);
        this.grade = grade;
    }

    public String getGrade() { return grade; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Grade: " + grade + " (Role: Student)");
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + grade;
    }

    public static Student fromDataString(String data) {
        String[] parts = data.split(",");
        if (parts.length < 3) throw new IllegalArgumentException("Invalid data: " + data);
        return new Student(parts[0], parts[1], parts[2]);
    }
}
