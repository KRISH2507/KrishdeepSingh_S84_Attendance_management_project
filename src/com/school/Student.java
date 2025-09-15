package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + this.id + ", Name: " + this.name);
        System.out.println("Role: Student, Grade Level: " + this.gradeLevel);
    }

    @Override
    public String toDataString() {
        return this.id + "," + this.name + "," + this.gradeLevel;
    }
}
