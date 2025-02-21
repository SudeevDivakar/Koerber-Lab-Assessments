package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(String id);
    public User saveUser(User user);
    public User updateUser(String id, User user);
    public void deleteUser(String id);
}
