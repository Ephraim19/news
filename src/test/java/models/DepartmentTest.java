package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    @Test
    void checksIfDepartmentNameGetterMethodReturnsValue() {
        Department department = new Department("Politics","All things politics",10);
        assertEquals("eph",department.getDepartmentName());
    }
    @Test
    void checksIfDescriptiongetterMethodReturnsValue() {
        Department department = new Department("Politics","All things politics",10);
        assertEquals("eph",department.getDescription());
    }
    @Test
    void checksIfTNumberOfPeopleGetterMethodReturnsValue() {
        Department department = new Department("Politics","All things politics",10);
        assertEquals("eph",department.getDepartmentName());
    }
}