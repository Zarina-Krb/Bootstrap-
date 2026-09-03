package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.Dao.RoleDao;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserService userService;
    private final RoleDao roleDao;

    @Autowired
    public DataInitializer(UserService userService, RoleDao roleDao) {
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATA INITIALIZER ЗАПУЩЕН");
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleDao.save(roleAdmin);
        Role roleUser = new Role("ROLE_USER");
        roleDao.save(roleUser);

        userService.add("admin", "Admin", "admin", 33, Set.of("ROLE_ADMIN"));
        userService.add("user", "User", "user", 36, Set.of("ROLE_USER"));

    }
}
