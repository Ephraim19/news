package models;

public class News {
    private Integer id;
    private String title;
    private String description;
    private String department;

    public News(String title, String description, String department) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.department = department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
