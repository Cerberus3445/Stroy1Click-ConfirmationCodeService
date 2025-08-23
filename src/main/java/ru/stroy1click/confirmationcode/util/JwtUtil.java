package ru.stroy1click.confirmationcode.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import ru.stroy1click.confirmationcode.dto.UserDto;

import java.security.Key;
import java.util.*;

public class JwtUtil {

    @Value(value = "${jwt.secret}")
    private static String SECRET;

    public static String generateToken(UserDto user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("emailConfirmed", user.getEmailConfirmed());
        return createToken(claims, user);
    }

    private static String createToken(Map<String, Object> claims, UserDto user) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 300))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private static Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
