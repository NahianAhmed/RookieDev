package com.nahian.github.io.rookiedev.Events;

import com.nahian.github.io.rookiedev.Models.User;
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
