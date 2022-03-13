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
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news_api";
        Sql2o sql2o = new Sql2o(connectionString, "eph1717", "eph1717");

        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();

        //Create
        post("/user/new", "application/json", (request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            UserDao.add(user);
            response.status(201);
            return gson.toJson(user);
        });

    }
}















