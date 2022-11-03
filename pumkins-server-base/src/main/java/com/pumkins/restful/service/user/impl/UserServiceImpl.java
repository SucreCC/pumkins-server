package com.pumkins.restful.service.user.impl;

import com.pumkins.entity.QUser;
import com.pumkins.entity.User;
import com.pumkins.querydsl.JPAQueryWrapper;
import com.pumkins.repository.UserRepository;
import com.pumkins.restful.service.user.UserService;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2022/11/03 23:26
 * @description: TODO
 */
@Component
public class UserServiceImpl implements UserService {

    private QUser qUser = QUser.user;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QueryFactory queryFactory;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean selectByUserNameAndEmail(String username, String email) {
        List<User> userList = JPAQueryWrapper.create(jpaQueryFactory.selectFrom(qUser))
            .where(qUser.username.eq(username).or(qUser.email.eq(email)))
            .build()
            .fetch();
        return !CollectionUtils.isEmpty(userList);
    }
}
