package com.zehuang;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasManagementApplicationTests {

//    @Test
//    void testGenJwt() {
//
//        // 1. 生成 SecretKey（HS256 专用）
//        SecretKey key = Keys.hmacShaKeyFor(
//                "yourSecretKeyyourSecretKeyyourSecretKey".getBytes()
//        );
//
//        // 2. 要放的 Claim
//        Map<String, Object> claims = Map.of(
//                "id", 10,
//                "username", "zhangsan"
//        );
//
//        // 3. 构建 Token（无 deprecated 的最新写法）
//        String token = Jwts.builder()
//                .subject("user")
//                .claims(claims)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 3600_000)) // 1小时
//                .signWith(key)
//                .compact();
//
//        System.out.println("JWT = " + token);
//    }
//
//    @Test
//    void testParseJwt() {
//        SecretKey key = Keys.hmacShaKeyFor(
//                "yourSecretKeyyourSecretKeyyourSecretKey".getBytes()
//        );
//
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWQiOjEwLCJ1c2VybmFtZSI6InpoYW5nc2FuIiwiaWF0IjoxNzYzMTY3OTUxLCJleHAiOjE3NjMxNzE1NTF9.6nDWI2SJl02u4QO6VlxJGZfmnyMu35asFU_7p_JpAhE";
//
//        var payload = Jwts.parser()
//                .verifyWith(key)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//
//        System.out.println("Claims = " + payload);
//    }

    private static final String SIGN_KEY = "SVRIRUlNQQ==SVRIRUlNQQ==SVRIRUlNQQ==";
    private static final long EXPIRE = 43200000L;

    @Test
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SIGN_KEY.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 生成 JWT
     */
    @Test
    public  String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(getKey())
                .compact();
    }

    /**
     * 解析 JWT
     */
    @Test
    public  Claims parseJWT(String jwt) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

}
