package com.nahian.github.io.rookiedev.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class NoteRestEvent extends ApplicationEvent {
    Long userId;
    public NoteRestEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }
}
