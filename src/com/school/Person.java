package com.school;

public abstract class Person {
    private static int counter = 1;
    private int id;
    private String name;

    public Person(String name) {
        this.name = name;
        this.id = counter++;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void displayDetails() {
        System.out.print("ID: " + id + ", Name: " + name);
    }

    public abstract String toDataString();
}
