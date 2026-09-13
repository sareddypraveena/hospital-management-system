package com.org.HMS.controller;

import com.org.HMS.entity.Admin;
import com.org.HMS.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PostMapping
    public Admin createUser(@RequestBody Admin user) {
        return userService.createUser(user);
    }

    // Get All Users
    @GetMapping
    public List<Admin> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User By ID
    @GetMapping("/{id}")
    public Admin getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}