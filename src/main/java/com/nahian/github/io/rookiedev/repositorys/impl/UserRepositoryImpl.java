package com.nahian.github.io.rookiedev.repositorys.impl;

import com.nahian.github.io.rookiedev.models.QUser;
import com.nahian.github.io.rookiedev.models.User;
import com.nahian.github.io.rookiedev.repositorys.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> findUserWithAddress(String address) {
        JPAQuery<User> userJPAQuery = new JPAQuery<>(entityManager);
        QUser user = new QUser("u");
        return  userJPAQuery.from(user)
                .where(user.address.eq(address))
                .fetch();
    }
}
