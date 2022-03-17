package com.nahian.github.io.rookiedev.Controllers;

import com.nahian.github.io.rookiedev.Events.UserDeleteEvent;
import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HomeApiController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getUsers();
    }
    @PostMapping("/create")
    public List<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return userService.getUsers();
    }

    @GetMapping("/delete/{id}")
    public List<User> deleteUser(@PathVariable Long id) {
        User user = userService.findUser(id);
        publisher.publishEvent(new UserDeleteEvent(this, user));
        return userService.getUsers();
    }

}
