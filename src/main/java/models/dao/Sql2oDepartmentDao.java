package models.dao;
import models.Department;
import org.sql2o.*;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentDao (Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (departmentName, description, numberOfPeople) VALUES (:departmentName, :description, :numberOfPeople)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }
}
