package models.dao;

import models.Department;
import models.User;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);
    List<User> getAll();
    User findById(int id);

}
