package com.nahian.github.io.rookiedev.services.impl;

import com.nahian.github.io.rookiedev.exception.NotFountException;
import com.nahian.github.io.rookiedev.models.Note;
import com.nahian.github.io.rookiedev.models.User;
import com.nahian.github.io.rookiedev.repositorys.NoteRepository;
import com.nahian.github.io.rookiedev.repositorys.UserRepository;
import com.nahian.github.io.rookiedev.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
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
        log.info("getting user " + id);
        return userRepository.findById(id).orElseThrow(NotFountException::new);
    }

    @Override
    public List<User> findUserWithAddress(String address) {
        return userRepository.findUserWithAddress(address);
    }

    @Transactional
    @Override
    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    @Transactional
    @Override
    public void deleteUserNotes(Long userId) {
        noteRepository.deleteAllByUserId(userId);
    }
}
