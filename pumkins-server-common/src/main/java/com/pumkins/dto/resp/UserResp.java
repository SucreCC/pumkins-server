package com.pumkins.dto.resp;

import lombok.Data;
import lombok.experimental.Accessors;

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
}
