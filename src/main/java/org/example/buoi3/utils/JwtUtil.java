package org.example.buoi3.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.buoi3.constants.AppEnv;
import org.example.buoi3.models.User;
import org.example.buoi3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@DependsOn("appEnv")
public class JwtUtil {

    private static final String SECRET_KEY = AppEnv.secretKey;
    private static final Long TIME_EXPIRATION = AppEnv.timeExpiration*10000;
    private final UserRepository userRepository;

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String extractUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("username").toString();
    }

    public Date extractExpiration(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

//    public Long getIdFromToken(){
//
//    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claim = new HashMap<>();
        User user = userRepository.findByUsername(userDetails.getUsername());
        claim.put("username",user.getUsername());
        claim.put("id",user.getId());
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setClaims(claim).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+TIME_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
}
