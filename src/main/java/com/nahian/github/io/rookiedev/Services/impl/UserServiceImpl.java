package com.nahian.github.io.rookiedev.Services.impl;

import com.nahian.github.io.rookiedev.Exception.NotFountException;
import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Repositorys.UserRepository;
import com.nahian.github.io.rookiedev.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @CachePut(value = "user", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @CacheEvict(value = "user", key = "#user.id")
    public User deleteUser(User user) {
        User u = userRepository.findById(user.getId()).orElseThrow(NotFountException::new);
        userRepository.delete(u);
        return u;
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(NotFountException::new);
    }
}
