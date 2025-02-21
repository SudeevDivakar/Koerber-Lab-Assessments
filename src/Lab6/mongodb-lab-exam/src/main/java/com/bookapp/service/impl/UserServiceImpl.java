package com.bookapp.service.impl;

import com.bookapp.entities.User;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.UserRepo;
import com.bookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found in database"));
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        User existingUser = getUser(id);
        existingUser.setId(id);
        return userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        User user = getUser(id);
        userRepo.delete(user);
    }

}
