package ru.kata.spring.boot_security.demo.Dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAllUsers();

    User findById(Long id);

    void update(User user);

    void delete(Long id);

    User findByUsername(String username);
}
