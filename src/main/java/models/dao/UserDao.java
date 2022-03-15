package models.dao;
import models.User;

import java.util.List;

public interface UserDao {
    //create
     void add(User user);

    //read users
    List<User> getAll();
    User findById(int id);
    List<User> getUserDepartment(String department);

}