package models;

public class News {
    private String title;
    private String description;
    private String department;

    public News(String title, String description, String department) {
        this.title = title;
        this.description = description;
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }
}
