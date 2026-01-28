package org.launchcode.MySchool.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private String secret = "yourSecretKey";  // Use a strong key in production

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 1 hour
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) { return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject(); }
    public String extractRole(String token) { return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role"); }
    public boolean isTokenExpired(String token) { return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().before(new Date()); }
    public boolean validateToken(String token, String username) { return (username.equals(extractUsername(token)) && !isTokenExpired(token)); }
}
