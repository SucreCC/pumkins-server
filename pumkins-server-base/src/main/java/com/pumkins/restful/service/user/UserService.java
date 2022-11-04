package com.pumkins.restful.service.user;

import com.pumkins.dto.resp.UserResp;
import com.pumkins.entity.User;

/**
 * @Author: dengKai
 * @Date: 2022-11-03-23-25
 * @Description: TODO
 */

public interface UserService {
    User registerUser(User user);

    Boolean selectByUserNameAndEmail(String username, String email);

    User selectByUserName(String username);
}
