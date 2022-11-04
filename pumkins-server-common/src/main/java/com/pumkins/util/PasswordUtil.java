package com.pumkins.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author: dengKai
 * @date: 2022/11/04 11:47
 * @description: TODO
 */

public class PasswordUtil {
    public static String encode(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean matching(String rawPassword, String encodedPassword){
        String encode = encode(rawPassword);
        return encodedPassword.equals(encode);
    }
}
