package com.freshfish.telisawebmanagement.utils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;
import java.util.Map;

/**
 * JWT令牌操作工具类
 * 提供生成令牌和校验令牌的功能
 */
public class JwtUtils {

    // JWT签名密钥（建议放到配置文件中）
    private static final String SECRET_KEY = "ZnJlc2hmaXNo";

    // 令牌过期时间，默认2小时（单位：毫秒）
    private static final long EXPIRATION_TIME = 7200000L;

    /**
     * 生成JWT令牌
     * @param claimsMap 要存储在令牌中的自定义数据
     * @return 生成的JWT令牌字符串
     */
    public static String generateToken(Map<String, Object> claimsMap) {
        // 校验参数
        if (claimsMap == null) {
            throw new IllegalArgumentException("Claims map cannot be null");
        }

        // 构建并生成JWT令牌
        return Jwts.builder()
                // 设置签名算法和密钥
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                // 添加自定义数据
                .addClaims(claimsMap)
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                // 构建令牌字符串
                .compact();
    }

    /**
     * 生成JWT令牌（重载方法，使用默认过期时间）
     * @param claimsMap 自定义数据
     * @param expirationTime 过期时间（毫秒）
     * @return 生成的JWT令牌字符串
     */
    public static String generateToken(Map<String, Object> claimsMap, long expirationTime) {
        if (claimsMap == null) {
            throw new IllegalArgumentException("Claims map cannot be null");
        }
        if (expirationTime <= 0) {
            throw new IllegalArgumentException("Expiration time must be positive");
        }

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claimsMap)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .compact();
    }

    /**
     * 校验JWT令牌的有效性，并返回令牌中的数据
     *
     * @param token 要校验的JWT令牌字符串
     * @throws RuntimeException 令牌无效时抛出异常
     */
    public static void validateToken(String token) {
        // 参数校验
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }

        try {
            // 解析并验证令牌
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("JWT令牌已过期", e);
        } catch (UnsupportedJwtException e) {
            throw new RuntimeException("不支持的JWT令牌格式", e);
        } catch (MalformedJwtException e) {
            throw new RuntimeException("JWT令牌格式错误", e);
        } catch (SignatureException e) {
            throw new RuntimeException("JWT签名验证失败", e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("JWT令牌参数错误", e);
        }
    }

    /**
     * 简单校验令牌是否有效（不返回数据，只返回布尔值）
     * @param token JWT令牌
     * @return true-有效，false-无效
     */
    public static boolean isTokenValid(String token) {
        try {
            validateToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}