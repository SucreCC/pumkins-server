package com.pumkins.restful.service.login;

import com.pumkins.dto.request.LoginReq;
import com.pumkins.dto.request.RegisterReq;
import com.pumkins.dto.resp.UserResp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: dengKai
 * @Date: 2022-11-03-21-59
 * @Description: TODO
 */

public interface LoginService {
    Boolean login(LoginReq loginReq, HttpServletRequest request, HttpServletResponse response);

    UserResp register(RegisterReq registerReq, HttpServletResponse response);
}
