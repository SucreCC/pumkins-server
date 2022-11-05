package com.pumkins.restful.controller.login;

import com.pumkins.dto.request.LoginReq;
import com.pumkins.dto.request.RegisterReq;
import com.pumkins.dto.resp.UserResp;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: dengKai
 * @date: 2022/10/28 08:26
 * @description: TODO
 */
@RestController
@RequestMapping("/pumkins")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public JsonResp<UserResp> login(@RequestBody LoginReq loginReq, HttpServletResponse response, HttpServletRequest request) {
        return JsonResp.success(loginService.login(loginReq, request, response));
    }

    @PostMapping("/register")
    public JsonResp<UserResp> register(@RequestBody RegisterReq registerReq, HttpServletResponse response) {
        return JsonResp.success(loginService.register(registerReq, response));
    }
}

