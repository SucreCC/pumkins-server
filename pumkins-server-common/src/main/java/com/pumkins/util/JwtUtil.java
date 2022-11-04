package com.pumkins.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pumkins.dto.resp.UserResp;
import com.pumkins.entity.User;

import java.util.Date;


/**
 * @author: dengKai
 * @date: 2022/11/04 18:24
 * @description: TODO
 */


/**
 * @program: JwtUtil
 * @Description: TODO
 * @Author: sucre1136@gmail.com
 */
public class JwtUtil {
    private static final String USERNAME = "username";
    private static final String ID = "id";
    private static final String SIGN = "sucre";
    private static final String TIME_STAMP = "timeStamp";
    private static final Long EXPIRATION_TIME = 1000L * 60 * 60 * 2;
    public static final String AUTH_HEAD_KEY = "Authorization";


    public static String buildJwtToken(UserResp user) {
        return JWT.create()
            .withClaim(USERNAME, user.getUsername())
            .withClaim(ID, user.getId())
            .withClaim(TIME_STAMP, new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC256(SIGN));
    }

    public static User decoder(String token) throws Exception {

        try {
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SIGN))
                .build()
                .verify(token);
            String username = jwt.getClaim(USERNAME).asString();
            Integer id = jwt.getClaim(ID).asInt();
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            return user;
        } catch (Exception ex) {
            throw new Exception("illegal token");
        }
    }
}



