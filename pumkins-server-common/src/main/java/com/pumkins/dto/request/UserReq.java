package com.pumkins.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2022/11/03 20:43
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class UserReq {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String icon;
    private String createDate;
    private String updateDate;
}
