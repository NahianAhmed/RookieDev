package com.nahian.github.io.rookiedev.controllers;

import com.nahian.github.io.rookiedev.models.User;
import com.nahian.github.io.rookiedev.models.UserAuth;
import com.nahian.github.io.rookiedev.objects.TokenRequest;
import com.nahian.github.io.rookiedev.objects.TokenResponse;
import com.nahian.github.io.rookiedev.repositorys.UserAuthRepository;
import com.nahian.github.io.rookiedev.repositorys.UserRepository;
import com.nahian.github.io.rookiedev.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WelComeWebController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserAuthRepository userAuthRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void postConstruct() {
        User user = User.builder()
                .name("Nahian")
                .address("Uttara")
                .email("nahianofficially@gmail.com")
                .mobile("01677035933")
                .build();
        if (userAuthRepository.findUserAuthByUsername(user.getName().toLowerCase()).isEmpty()) {
            userRepository.save(user);
            UserAuth auth = UserAuth.builder()
                    .username(user.getName().toLowerCase())
                    .password(user.getMobile())
                    .user(user)
                    .build();
            userAuthRepository.save(auth);
        }
    }

    @GetMapping("/welcome")
    public String index() {
        return "Welcome";
    }

    @PostMapping("/get-token")
    public TokenResponse getToken(@RequestBody TokenRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid User Name or Password");
        }
        return new TokenResponse(jwtUtil.generateToken(request.getUsername()));
    }
}
