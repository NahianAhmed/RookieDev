package com.nahian.github.io.rookiedev.Services.impl;

import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Repositorys.UserRepository;
import com.nahian.github.io.rookiedev.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
