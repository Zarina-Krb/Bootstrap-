package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String add(@RequestParam("userName") String userName,
                      @RequestParam("lastName") String lastName,
                      @RequestParam("password") String password,
                      @RequestParam("age") int age, @RequestParam("roles") Set<String> roles) {
        userService.add(userName, lastName, password, age, roles);
        return "redirect:/admin";
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("allRoles", userService.getAllRoles());
        return "admin";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") Long id,
                         @RequestParam("userName") String userName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("password") String password,
                         @RequestParam("age") int age,
                         @RequestParam("roles") Set<String> roles) {
        userService.update(id, userName, lastName, password, age, roles);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
