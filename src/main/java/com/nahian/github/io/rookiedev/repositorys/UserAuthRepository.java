package com.nahian.github.io.rookiedev.repositorys;

import com.nahian.github.io.rookiedev.models.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findUserAuthByUsername(String username);
}
