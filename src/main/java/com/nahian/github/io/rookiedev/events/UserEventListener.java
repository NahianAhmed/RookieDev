package com.nahian.github.io.rookiedev.events;

import com.nahian.github.io.rookiedev.facade.UserServiceFacade;
import com.nahian.github.io.rookiedev.models.User;
import com.nahian.github.io.rookiedev.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Log4j2
public class UserEventListener  {
    private final UserService userService;
    private final UserServiceFacade userServiceFacade;

    @Async
    @Transactional
    @EventListener
    public void handleUserDeleteEvent(UserDeleteEvent event) {
        User user = event.getUser();
        userService.deleteUser(user);
        log.warn("Delete user : " + user.getName());
    }

    @Transactional
    @EventListener
    public void handleNoteResetEvent(NoteRestEvent event) {
        userServiceFacade.resetNote(event.userId);
        log.warn("reset note : " + event.userId);
    }
}
