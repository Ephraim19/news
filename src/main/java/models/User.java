package models;

public class User {
    private Integer id;
    private String name;
    private String position;
    private String role;
    private String department;

    public User(String name, String position, String role, String department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.role = role;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
