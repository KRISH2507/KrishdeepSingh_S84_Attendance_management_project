package com.school;

public abstract class Person {
    private String id;  // String ID
    private String name;
    private static int counter = 1;

    public Person(String name) {
        this.name = name;
        this.id = String.format("S%03d", counter++);
    }

    public Person(String id, String name) { // For loading from file
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void setId(String id) { this.id = id; }

    public void displayDetails() {
        System.out.print("ID: " + id + ", Name: " + name);
    }

    public abstract String toDataString();
}
