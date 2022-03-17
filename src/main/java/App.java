import static spark.Spark.*;
import models.*;
import models.dao.*;
import exceptions.ApiException;
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

        String connectionString = "jdbc:postgresql://localhost:5432/news_api";
     Sql2o sql2o = new Sql2o(connectionString, "ephu17", "ephu17");

//        String connectionString = "jdbc:postgresql://ec2-44-194-167-63.compute-1.amazonaws.com:5432/da0v6pcmgs8d87";
//        Sql2o sql2o = new Sql2o(connectionString, "oqwkhjkocsrmvg", "2f8eacbc3b57758a99ccfb6b68f953bc32c170ad0d00aed5b5720fb1144fbcaa");

        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();

        //Create user
        post("/user/new", "application/json", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            userDao.add(user);
            response.status(201);
            response.type("application/json");
            return gson.toJson(user);
        });

        //Create news
        post("/news/new", "application/json", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            newsDao.add(news);
            response.status(201);
            response.type("application/json");
            return gson.toJson(news);
        });
        //Create departments
        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);

        });
        //read users
        get("/users", "application/json", (req, res) -> {
            if(userDao.getAll().size() > 0) {
                return gson.toJson(userDao.getAll());
            }else{
                return "{\"message\":\"No users are currently listed in the database.\"}";
            }
        });

        get("/users/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            User user = userDao.findById(UserId);
            if(user == null){
                res.status(404);
                return "{\"message\":\"No users with the id currently listed in the database.\"}";
            }
            return gson.toJson(user);
        });

        //read departments
        get("/departments", "application/json", (req, res) -> {
            if(departmentDao.getAll().size() > 0) {
                return gson.toJson(departmentDao.getAll());
            }else {
                return "{\"message\":\"No departments are currently listed in the database.\"}";
            }
        });

        get("/departments/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            Department department = departmentDao.findById(UserId);
            if(department == null){
                res.status(404);
                return "{\"message\":\"No departments with the id currently listed in the database.\"}";
            }
            return gson.toJson(department);
        });

        //read news
        get("/news", "application/json", (req, res) -> {
            if(newsDao.getAll().size() > 0) {
                return gson.toJson(newsDao.getAll());
            }else {
                return "{\"message\":\"No news are currently listed in the database.\"}";
            }
        });


        get("/news/:id", "application/json", (req, res) -> {
            int UserId = Integer.parseInt(req.params("id"));
            News news = newsDao.findById(UserId);
            if(news == null){
                res.status(404);
                return "{\"message\":\"No news with the id currently listed in the database.\"}";
            }
            return gson.toJson(news);
        });
        //filter
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });
        after((req, res) ->{
            res.type("application/json");
        });
    }
}















