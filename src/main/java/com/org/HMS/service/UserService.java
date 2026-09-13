package com.org.HMS.service;

import com.org.HMS.entity.Admin;
import com.org.HMS.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final AdminRepository userRepository;

    public UserService(AdminRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User
    public Admin createUser(Admin user) {
        return userRepository.save(user);
    }

    // Get All Users
    public List<Admin> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By ID
    public Admin getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}