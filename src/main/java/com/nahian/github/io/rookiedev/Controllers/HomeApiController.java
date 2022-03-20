package com.nahian.github.io.rookiedev.Controllers;

import com.nahian.github.io.rookiedev.Events.UserDeleteEvent;
import com.nahian.github.io.rookiedev.Exception.UserException;
import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Services.UserService;
import com.nahian.github.io.rookiedev.Validators.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HomeApiController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final UserValidator userValidator;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getUsers();
    }
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    @PostMapping("/create")
    public List<User> createUser(@RequestBody User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            throw new UserException(Objects.requireNonNull(result.getFieldError()));
        }
        userService.createUser(user);
        return userService.getUsers();
    }
    @PostMapping("/update")
    public User updateUser(@RequestBody User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            throw new UserException(Objects.requireNonNull(result.getFieldError()));
        }
        return userService.updateUser(user);
    }


    @GetMapping("/delete/{userId}")
    public List<User> deleteUser(@PathVariable Long userId) {
        User user = userService.findUser(userId);
        publisher.publishEvent(new UserDeleteEvent(this, user));
        return userService.getUsers();
    }

}
