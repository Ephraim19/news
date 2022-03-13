package models;

public class Department {
    private String departmentName;
    private String description;
    private Integer numberOfPeople;

    public Department(String departmentName, String description,Integer numberOfPeople) {
        this.departmentName = departmentName;
        this.description = description;
        this.numberOfPeople = numberOfPeople;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getDescription() {
        return description;
    }
}
