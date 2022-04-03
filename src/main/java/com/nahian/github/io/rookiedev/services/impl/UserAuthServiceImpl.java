package com.nahian.github.io.rookiedev.services.impl;

import com.nahian.github.io.rookiedev.models.UserAuth;
import com.nahian.github.io.rookiedev.repositorys.UserAuthRepository;
import com.nahian.github.io.rookiedev.services.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserAuthServiceImpl implements UserAuthService {

    private final UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth auth = userAuthRepository.findUserAuthByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user name not found"));
        return new User(auth.getUsername(), auth.getPassword(), new ArrayList<>());
    }
}
