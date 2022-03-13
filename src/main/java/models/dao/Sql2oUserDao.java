package models.dao;

import models.User;
import org.sql2o.*;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (name, position, role, , department) VALUES (:name, :position, :role, :department)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }
}








