package com.nahian.github.io.rookiedev.Controllers;

import com.nahian.github.io.rookiedev.Models.User;
import com.nahian.github.io.rookiedev.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HomeApiController {

    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "hello";
    }
    @GetMapping("/users")
    public List<User> getAllUser() {
        List<User> userList = userService.getUsers();
        userList.forEach(user -> {
            String str = String.valueOf(user.getName());
           log.info(str);
        });
        return userService.getUsers();
    }

}
