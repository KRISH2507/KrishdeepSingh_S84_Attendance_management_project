package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getRole() { return role; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Role: " + role + " (Role: Staff)");
    }

    @Override
    public String toDataString() {
        return getName() + "," + role;
    }

    public static Staff fromDataString(String line) {
        String[] parts = line.split(",");
        return new Staff(parts[0], parts[1]);
    }
}
