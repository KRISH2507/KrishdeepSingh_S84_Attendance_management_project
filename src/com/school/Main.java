package com.school;

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course();
        c1.setDetails(1, "DBMS");
        
        Course c2 = new Course();
        c2.setDetails(2, "LHT");

        Student student1 = new Student("Pratham", "10th Grade");
        Student student2 = new Student("Krish", "12th Grade");

        Teacher teacher = new Teacher("Mr. Sharma", "Mathematics");

        Staff staff = new Staff("Mrs. Verma", "Librarian");

        Student[] students = {student1, student2};
        System.out.println("Registered Students:");
        for (Student s : students) {
            s.displayDetails();
        }

        Course[] courses = {c1, c2};
        System.out.println("\nRegistered Courses:");
        for (Course c : courses) {
            c.displayDetails();
        }

        System.out.println("\nRegistered Teacher:");
        teacher.displayDetails();

        System.out.println("\nRegistered Staff:");
        staff.displayDetails();
    }
}
