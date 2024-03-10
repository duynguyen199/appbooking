package org.example.buoi3.services.imp.security;

import org.example.buoi3.models.User;
import org.example.buoi3.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
/**
 *
 * Đầu tiên là lấy ra thông tin user + quyền và map nó vào thông tin trong thư viện
 * **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /**
         * Lấy ra thông tin user
         * **/
        User user = userRepository.findByUsername(username);
        if (user== null){
            throw new UsernameNotFoundException("Not found username: "+username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        /**
         * Map quyền từ user vào trong thư viện
         * **/
        user.getRoles().forEach(item ->{
            grantedAuthorities.add(new SimpleGrantedAuthority(item.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
