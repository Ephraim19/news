package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void checksIfNameGetterMethodReturnsValue() {
        User user = new User("eph","manager","editor","sports");
        assertEquals("eph",user.getName());
    }
    @Test
    void checksIfPositionGetterMethodReturnsValue() {
        User user = new User("eph","manager","editor","sports");
        assertEquals("manager",user.getPosition());
    }
    @Test
    void checksIfRoleGetterMethodReturnsValue() {
        User user = new User("eph","manager","editor","sports");
        assertEquals("eph",user.getRole());
    }
    @Test
    void checksIfDepartmentGetterMethodReturnsValue() {
        User user = new User("eph","manager","editor","sports");
        assertEquals("eph",user.getDepartment());
    }
}










