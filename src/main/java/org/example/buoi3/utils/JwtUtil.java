package org.example.buoi3.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.buoi3.constants.AppEnv;
import org.example.buoi3.models.User;
import org.example.buoi3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET_KEY = AppEnv.secretKey;
    private static final Integer TIME_EXPIRATION = AppEnv.timeExpiration;
    private final UserRepository userRepository;

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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
