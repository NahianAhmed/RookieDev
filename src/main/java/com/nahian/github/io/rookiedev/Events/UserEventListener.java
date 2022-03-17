package com.nahian.github.io.rookiedev.Events;

import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class UserEventListener  {
    private final UserService userService;

    @EventListener
    public void handleUserDeleteEvent(UserDeleteEvent event) {
        User user = event.getUser();
        userService.deleteUser(user);
        log.warn("Delete user : " + user.getName());
    }
}
