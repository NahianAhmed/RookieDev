package com.nahian.github.io.rookiedev.controllers;

import com.nahian.github.io.rookiedev.objects.TokenRequest;
import com.nahian.github.io.rookiedev.objects.TokenResponse;
import com.nahian.github.io.rookiedev.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WelComeWebController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

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
