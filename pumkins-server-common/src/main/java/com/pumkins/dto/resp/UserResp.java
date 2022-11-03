package com.pumkins.dto.resp;

import com.pumkins.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * @author: dengKai
 * @date: 2022/11/04 00:29
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class UserResp {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String icon;

    public static UserResp build(User user){
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user,userResp);
        return userResp;
    }
}
