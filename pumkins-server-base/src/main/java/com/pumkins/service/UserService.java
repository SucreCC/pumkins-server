package com.pumkins.service;

import com.pumkins.dto.response.UserResp;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2021/12/05 10:42
 * @description: TODO
 */

public interface UserService {

    List<UserResp> getUserInfo();
}
