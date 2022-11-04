package com.pumkins.restful.service.login.impl;

import com.pumkins.dto.request.RegisterReq;
import com.pumkins.entity.User;
import com.pumkins.repository.UserRepository;
import com.pumkins.restful.service.login.LoginService;
import com.pumkins.restful.service.user.UserService;
import com.querydsl.core.QueryFactory;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2022/11/03 22:20
 * @description: TODO
 */
@Component
public class LoginServiceImpl implements LoginService {
    private static final String DEFAULT_USER_ICON = "assets/my-assets/images/user/default-icon.png";


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QueryFactory queryFactory;

    @Autowired
    private UserService userService;


    @Override
    public void login() {

    }

    @Override
    public User register(RegisterReq registerReq) {
        return existUser(registerReq) ? null : userService.registerUser(buildUser(registerReq));
    }

    private Boolean existUser(RegisterReq registerReq) {
        return userService.selectByUserNameAndEmail(registerReq.getUsername(), registerReq.getEmail());
    }

    private User buildUser(RegisterReq registerReq) {
        return new User()
            .setUsername(registerReq.getUsername())
            .setPassword(registerReq.getPassword())
            .setEmail(registerReq.getEmail())
            .setIcon(DEFAULT_USER_ICON)
            .setCreateDate(new Date())
            .setUpdateDate(new Date());
    }
}
