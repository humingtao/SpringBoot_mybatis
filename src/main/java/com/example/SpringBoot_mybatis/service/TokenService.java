package com.example.SpringBoot_mybatis.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.SpringBoot_mybatis.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * 需要写token的生成方法
 * Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
 * withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
 */
@Service("TokenService")
public class TokenService {
    public String getToken(SysUser sysuser) {
        String token="";
        token= JWT.create().withAudience(sysuser.getId())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(sysuser.getUserPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
