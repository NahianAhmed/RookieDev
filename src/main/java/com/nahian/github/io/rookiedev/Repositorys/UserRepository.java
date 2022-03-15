package com.nahian.github.io.rookiedev.Repositorys;

import com.nahian.github.io.rookiedev.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
