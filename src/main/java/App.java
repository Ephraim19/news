import static spark.Spark.*;
import models.*;
import models.dao.*;
import com.google.gson.Gson;
import org.sql2o.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Sql2oUserDao userDao;
        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news_api";
        Sql2o sql2o = new Sql2o(connectionString, "ephu17", "ephu17");

        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();

        //Create user
        post("/user/new", "application/json", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);//make with GSON
            userDao.add(user);//Do our thing with our DAO
            response.status(201);//everything went well - update the response status code
            response.type("application/json");
            return gson.toJson(user);//send it back to be displayed
        });

        //Create news
        post("/news/new", "application/json", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);//make with GSON
            newsDao.add(news);//Do our thing with our DAO
            response.status(201);//everything went well - update the response status code
            response.type("application/json");
            return gson.toJson(news);//send it back to be displayed
        });
        //Create departments
        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);//make with GSON
            departmentDao.add(department);//Do our thing with our DAO
            response.status(201);//everything went well - update the response status code
            response.type("application/json");
            return gson.toJson(department);//send it back to be displayed

        });
        //read users
        get("/users", "application/json", (req, res) -> {
            System.out.println(userDao.getAll());

            if(userDao.getAll().size() > 0){
                return gson.toJson(userDao.getAll());
            }

            else {
                return "{\"message\":\"No users found.\"}";
            }

        });

        get("/users/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            User user = userDao.findById(UserId);
            return gson.toJson(UserId);
        });
        //read departments
        get("/departments", "application/json", (req, res) -> {

            if(departmentDao.getAll().size() > 0){
                return gson.toJson(departmentDao.getAll());
            }

            else {
                return "{\"message\":\"No departments found.\"}";
            }

        });


    }
}















