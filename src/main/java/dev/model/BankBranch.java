package dev.model;

public class BankBranch {
    private int id;
    private String name;
    private String location;
    private String description;

    public BankBranch() {}

    public BankBranch(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) { this.location = location; }

    public String getLocation() {
        return location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
