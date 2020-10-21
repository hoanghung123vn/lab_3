package dao;

import model.Todo;

public interface TodoDao {
    Todo findAll();

    Todo create(String title);

    Todo update(int id, String title);

    void deleteById(int id);
}
