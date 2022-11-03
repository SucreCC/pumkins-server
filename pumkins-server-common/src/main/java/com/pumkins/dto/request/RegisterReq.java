package com.pumkins.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2022/11/03 22:02
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class RegisterReq {
    private String username;
    private String password;
    private String email;
}
