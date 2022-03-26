package com.nahian.github.io.rookiedev.repositorys;

import com.nahian.github.io.rookiedev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom {
}
