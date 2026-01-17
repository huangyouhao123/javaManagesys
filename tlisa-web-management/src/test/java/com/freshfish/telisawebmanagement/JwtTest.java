package com.freshfish.telisawebmanagement;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void test() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "tom");
        String jwt= Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"ZnJlc2hmaXNo")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis()+1000*20))
                .compact();
        System.out.println(jwt);
    }
//    eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0b20iLCJleHAiOjE3Njg1Njc1MjJ9.gQO6ZKr0pTtyla4wPYP7y8mpD85M1Nra8cGuRx-Abok
    @Test
    public void test2() {
        Claims claims = Jwts.parser().setSigningKey("ZnJlc2hmaXNo")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0b20iLCJleHAiOjE3Njg1NjQ1MTF9.mtsPLfU0HGt-QbJtE7NcgcUIy9nXNBo4pleO37qSp1g")
                        .getBody();
        System.out.println("验证成功");
        System.out.println(claims);

    }
}
