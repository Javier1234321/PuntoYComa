package com.springboot.app.auth.jwt;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    // Crear el token
    public String generateAccessToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(
                        System.currentTimeMillis()
                                + Long.parseLong(timeExpiration)
                ))
                .signWith(getSignatureKey())
                .compact();
    }

    // Validar token
    public boolean isTokenValid(String token) {

        try {

            Jwts.parser()
                    .verifyWith(getSignatureKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // Obtener email
    public String getEmail(String token) {

        return getClaim(token, Claims::getSubject);
    }

    // Obtener un Claim específico
    public <T> T getClaim(
            String token,
            Function<Claims, T> claimsFunction) {

        Claims claims = extractAllClaims(token);

        return claimsFunction.apply(claims);
    }

    // Obtener todos los Claims
    public Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSignatureKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // Obtener la clave utilizada para firmar/verificar
    public SecretKey getSignatureKey() {

        byte[] keyBytes = Decoders.BASE64.decode(secretKey);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
