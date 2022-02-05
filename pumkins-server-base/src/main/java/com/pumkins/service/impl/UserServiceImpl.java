package com.pumkins.service.impl;

import com.pumkins.dto.response.UserResp;
import com.pumkins.entity.QUser;
import com.pumkins.entity.User;
import com.pumkins.repository.UserRepository;
import com.pumkins.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengKai
 * @date: 2021/12/05 10:45
 * @description: TODO
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserResp> getUserInfo() {
        User user = new User().setSchool("hhhh").setName("eeee");
        userRepository.save(user);
        QUser qUser = QUser.user;

        List<UserResp> collect = userRepository.findAll()
                .stream()
                .map(UserResp::convert)
                .collect(Collectors.toList());

//         JPAQueryWrapper.create(jpaQueryFactory.selectFrom(qUser))
//                .build()
//                .fetch()
//                .stream()
//                .map(user1 -> UserResp.convert(user1))
//                .collect(Collectors.toList());

        System.out.println(collect);
        return collect;
    }
}
