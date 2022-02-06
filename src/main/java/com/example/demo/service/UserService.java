package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User getCurrentUser();

    User getUserByLogin(String login);

    Iterable<User> getUsers();

    User create(User user);
}
