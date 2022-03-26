package com.nahian.github.io.rookiedev.repositorys;

import com.nahian.github.io.rookiedev.models.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUserWithAddress(String address);
}
