//package models.dao;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.sql2o.*;
//import models.User;
//import static org.junit.jupiter.api.Assertions.*;
//
//class Sql2oUserDaoTest {
//    private Connection conn;
//    private Sql2oUserDao userDao;
//
//    @BeforeAll
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "ephu17", "ephu17");
//        userDao = new Sql2oUserDao(sql2o);
//        conn = sql2o.open();
//    }
//
//    @AfterAll
//    public void tearDown() throws Exception {
//        conn.close();
//    }
//
//    @Test
//    public void addingUserSetsId() throws Exception {
//        User testUser = setupReview();
//        assertEquals(1, testUser.getId());
//    }
//}