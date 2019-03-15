package repositories;

import models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void save(User user);

    boolean isExist(String name, String password);
}