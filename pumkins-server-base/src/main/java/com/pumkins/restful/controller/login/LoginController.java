package com.pumkins.restful.controller.login;

import com.pumkins.dto.request.LoginReq;
import com.pumkins.dto.request.RegisterReq;
import com.pumkins.dto.resp.UserResp;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.entity.User;
import com.pumkins.restful.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public JsonResp<String> login(@RequestBody LoginReq loginReq) {
        return JsonResp.success();
    }

    @PostMapping("/register")
    public JsonResp<User> register(@RequestBody RegisterReq registerReq) {
        return JsonResp.success(loginService.register(registerReq));
    }
}

