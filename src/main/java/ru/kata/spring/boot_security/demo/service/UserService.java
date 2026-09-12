package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User add(String userName, String lastName, String password, int age, Set<String> roles);

    List<User> getAllUsers();

    User findById(Long id);

    void update(Long id, String userName, String lastName, String password, int age, Set<String> roles);

    void delete(Long id);

    User findByUsername(String username);
}
