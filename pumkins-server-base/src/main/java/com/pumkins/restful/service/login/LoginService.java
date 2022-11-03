package com.pumkins.restful.service.login;

import com.pumkins.dto.request.RegisterReq;
import com.pumkins.entity.User;

/**
 * @Author: dengKai
 * @Date: 2022-11-03-21-59
 * @Description: TODO
 */

public interface LoginService {
    void login();

    User register(RegisterReq registerReq);
}
