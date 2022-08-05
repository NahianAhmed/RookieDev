package com.nahian.github.io.rookiedev.facade.impl;

import com.nahian.github.io.rookiedev.facade.UserServiceFacade;
import com.nahian.github.io.rookiedev.models.Note;
import com.nahian.github.io.rookiedev.models.User;
import com.nahian.github.io.rookiedev.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceFacadeImpl implements UserServiceFacade {

    private final UserService userService;

    @Transactional
    @Override
    public void resetNote(Long userId) {
        userService.deleteUserNotes(userId);
        Note note = Note.builder()
                .note("delete note")
                .userId(userId)
                .build();
        userService.saveNote(note);
        log.info("reset done.");
    }
}
