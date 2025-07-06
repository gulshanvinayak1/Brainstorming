//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String SECRET_KEY;

    public JwtUtil(@Value("${jwt.secret}") String secretKey) {
        this.SECRET_KEY = secretKey;
    }

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 36000000L)).signWith(SignatureAlgorithm.HS256, this.SECRET_KEY).compact();
    }

    public String extractUsername(String token) {
        return ((Claims)Jwts.parser().setSigningKey(this.SECRET_KEY).parseClaimsJws(token).getBody()).getSubject();
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = this.extractUsername(token);
        return extractedUsername.equals(username) && !this.isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return ((Claims)Jwts.parser().setSigningKey(this.SECRET_KEY).parseClaimsJws(token).getBody()).getExpiration().before(new Date());
    }
}
