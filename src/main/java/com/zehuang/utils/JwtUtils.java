package com.zehuang.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SIGN_KEY = "SVRIRUlNQQ==SVRIRUlNQQ==SVRIRUlNQQ==123abc";
    private static final long EXPIRE = 43200000L;

    private static SecretKey getKey() {
        return Keys.hmacShaKeyFor(SIGN_KEY.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 生成 JWT
     */
    public static String generateJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(getKey())
                .compact();
        return jwt;
    }

    /**
     * 解析 JWT
     */
    public static Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
        return claims;
    }

}
