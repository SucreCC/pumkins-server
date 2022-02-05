package com.pumkins.dto.response;

import com.pumkins.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * @author: dengKai
 * @date: 2021/12/05 10:59
 * @description: TODO
 */
@Data
@Accessors
public class UserResp {
    private Integer id;
    private String name;
    private String school;

    public static UserResp convert(User user) {
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        return userResp;
    }
}
