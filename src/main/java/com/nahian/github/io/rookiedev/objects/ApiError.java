package com.nahian.github.io.rookiedev.objects;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {
    private String message;
    private HttpStatus status;
    private LocalDateTime time;
}
