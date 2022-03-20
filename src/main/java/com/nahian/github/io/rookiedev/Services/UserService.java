package com.nahian.github.io.rookiedev.Services;

import com.nahian.github.io.rookiedev.Models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User createUser(User user);

    User updateUser(User user);

    User deleteUser(User user);

    User findUser(Long id);
}
