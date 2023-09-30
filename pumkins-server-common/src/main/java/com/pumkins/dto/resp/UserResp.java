package com.pumkins.dto.resp;

import com.pumkins.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

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
    private String email;
    private String icon;
    /**
     * host,user,normal
     */
    private String role;

    public static UserResp build(User user) {
        UserResp userResp = new UserResp();
        if (Objects.nonNull(user)) {
            BeanUtils.copyProperties(user, userResp);
        }
        return userResp;
    }
}
