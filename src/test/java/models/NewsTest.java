package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {
    @Test
    void checksIfTitleGetterMethodReturnsValue() {
        News news = new News("Elections","9th August elections","politics");
        assertEquals("Elections",news.getTitle());
    }
    @Test
    void checksIfDescGetterMethodReturnsValue() {
        News news = new News("Elections","9th August elections","politics");
        assertEquals("9th August elections",news.getDescription());
    }
    @Test
    void checksIfDepartmentGetterMethodReturnsValue() {
        News news = new News("Elections","9th August elections","politics");
        assertEquals("politics",news.getDepartment());
    }
}