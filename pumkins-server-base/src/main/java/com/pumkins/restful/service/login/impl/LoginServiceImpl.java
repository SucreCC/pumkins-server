package com.pumkins.restful.service.login.impl;

import com.pumkins.dto.enus.RoleType;
import com.pumkins.dto.request.LoginReq;
import com.pumkins.dto.request.RegisterReq;
import com.pumkins.dto.resp.UserResp;
import com.pumkins.entity.User;
import com.pumkins.repository.UserRepository;
import com.pumkins.restful.service.login.LoginService;
import com.pumkins.restful.service.user.UserService;
import com.pumkins.util.JwtUtil;
import com.pumkins.util.PasswordUtil;
import com.querydsl.core.QueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Boolean login(LoginReq loginReq, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.selectByUserName(loginReq.getUsername());
        boolean isMatching = PasswordUtil.matching(loginReq.getPassword(), user.getPassword());
        if (isMatching) {
            bindTokenToResponseHeader(UserResp.build(user), response);
        }
        return isMatching;
    }


    @Override
    public UserResp register(RegisterReq registerReq, HttpServletResponse response) {
        UserResp userResp = new UserResp();
        if (!existUser(registerReq)) {
            userResp = UserResp.build(userService.registerUser(buildUser(registerReq)));
            bindTokenToResponseHeader(userResp, response);
        }
        return userResp;
    }

    private Boolean existUser(RegisterReq registerReq) {
        return userService.selectByUserNameAndEmail(registerReq.getUsername(), registerReq.getEmail());
    }

    private User buildUser(RegisterReq registerReq) {
        return new User()
            .setUsername(registerReq.getUsername())
            .setPassword(PasswordUtil.encode(registerReq.getPassword()))
            .setEmail(registerReq.getEmail())
            .setRole(RoleType.NORMAL.getIndex().toString())
            .setIcon(DEFAULT_USER_ICON)
            .setCreateDate(new Date())
            .setUpdateDate(new Date());
    }

    private void bindTokenToResponseHeader(UserResp userResp, HttpServletResponse response) {
        response.setHeader(JwtUtil.AUTH_HEAD_KEY, JwtUtil.buildJwtToken(userResp));
    }

}
