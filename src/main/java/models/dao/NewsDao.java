package models.dao;
import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News news);
    //read users
    List<News> getAll();
    News findById(int id);
}
