import static spark.Spark.*;
import models.*;
import models.dao.*;
import com.google.gson.Gson;
import org.sql2o.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        Sql2oUserDao userDao;
        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Connection conn;
        Gson gson = new Gson();

//        String connectionString = "jdbc:postgresql://localhost:5432/news_api";
//        Sql2o sql2o = new Sql2o(connectionString, "ephu17", "ephu17");

        String connectionString = "jdbc:postgresql://ec2-44-194-167-63.compute-1.amazonaws.com;5432/da0v6pcmgs8d87";
        Sql2o sql2o = new Sql2o(connectionString, "oqwkhjkocsrmvg", "2f8eacbc3b57758a99ccfb6b68f953bc32c170ad0d00aed5b5720fb1144fbcaa");

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
            return gson.toJson(userDao.getAll());

        });

        get("/users/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            User user = userDao.findById(UserId);
            return gson.toJson(user);
        });

        //read departments
        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentDao.getAll());
        });

        get("/departments/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            Department department = departmentDao.findById(UserId);
            return gson.toJson(department);
        });

        //read news
        get("/news", "application/json", (req, res) -> {
            return gson.toJson(newsDao.getAll());
        });

        get("/news/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            News news = newsDao.findById(UserId);
            return gson.toJson(news);
        });

        //getting all users in a specific department
        get("/dep/:department", "application/json", (req, res) -> {
            int Userdep = Integer.parseInt(req.params("department"));
            User users = userDao.findById(Userdep);
            return gson.toJson(users);
        });

    }
}















