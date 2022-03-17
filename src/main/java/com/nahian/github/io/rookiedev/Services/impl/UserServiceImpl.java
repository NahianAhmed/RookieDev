package com.nahian.github.io.rookiedev.Services.impl;

import com.nahian.github.io.rookiedev.Exception.NotFountException;
import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Repositorys.UserRepository;
import com.nahian.github.io.rookiedev.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        User u = userRepository.findById(user.getId()).orElse(null);
        if (u!=null) {
            userRepository.delete(u);
        }
       return u;
    }

    @SneakyThrows
    @Override
    public User findUser(Long id)  {
        User user = userRepository.findById(id).orElseThrow(NotFountException::new);
        return user;
    }
}
