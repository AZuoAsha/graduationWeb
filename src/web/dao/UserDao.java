package web.dao;

import web.User;

public interface UserDao {
    void add(User user);
    void delete(String naem);
    void update(String name);
    void find(String name);
}
