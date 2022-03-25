package com.nahian.github.io.rookiedev.services;

import com.nahian.github.io.rookiedev.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(User user);

    User findUser(Long id);
}
