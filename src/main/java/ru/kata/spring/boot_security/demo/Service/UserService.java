package ru.kata.spring.boot_security.demo.Service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User add(User user, Set<String> roles);

    List<User> getAllUsers();

    User findById(Long id);

    void update(User user);

    void delete(Long id);

    User findByUsername(String username);
}
