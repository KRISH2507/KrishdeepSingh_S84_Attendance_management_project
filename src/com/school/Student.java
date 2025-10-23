package com.school;

public class Student extends Person implements Storable {

    private String grade;

    public Student(String name, String grade) {
        super(name);
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

    public void setId(int id) {
        // Used for loading from file
        try {
            java.lang.reflect.Field field = Person.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(this, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student fromDataString(String line) {
        String[] parts = line.split(",");
        Student s = new Student(parts[1], parts[2]);
        s.setId(Integer.parseInt(parts[0]));
        return s;
    }
}
