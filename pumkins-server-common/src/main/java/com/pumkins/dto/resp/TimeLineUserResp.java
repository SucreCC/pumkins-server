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
public class TimeLineUserResp {
    private Integer userId;
    private String username;

    public static TimeLineUserResp ConvertToUserResp(User user) {
       return new TimeLineUserResp()
            .setUserId(user.getId())
            .setUsername(user.getUsername());
    }
}
