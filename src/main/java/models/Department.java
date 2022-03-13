package models;

public class Department {
    private  Integer id;
    private String departmentName;
    private String description;
    private Integer numberOfPeople;

    public Department(String departmentName, String description,Integer numberOfPeople) {
        this.id = id;
        this.departmentName = departmentName;
        this.description = description;
        this.numberOfPeople = numberOfPeople;
    }

    public void setId(Integer id) {
        this.id = id;
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
