package com.nahian.github.io.rookiedev.events;

import com.nahian.github.io.rookiedev.models.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class UserDeleteEvent extends ApplicationEvent {
    User user;
    public UserDeleteEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
