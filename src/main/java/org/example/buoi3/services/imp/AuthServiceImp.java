package org.example.buoi3.services.imp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.example.buoi3.exception.BadRequestException;
import org.example.buoi3.inputs.AuthenticationRequest;
import org.example.buoi3.inputs.UserDataInput;
import org.example.buoi3.models.Images;
import org.example.buoi3.models.Role;
import org.example.buoi3.models.User;
import org.example.buoi3.outputs.auth.AuthenticationResponse;
import org.example.buoi3.repositories.ImageRepository;
import org.example.buoi3.repositories.RoleRepository;
import org.example.buoi3.repositories.UserRepository;
import org.example.buoi3.services.AuthService;
import org.example.buoi3.services.imp.security.MyUserDetailService;
import org.example.buoi3.utils.JwtUtil;
import org.example.buoi3.utils.UploadImageUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImp implements AuthService {
    
    private final UserRepository userRepository;
    private final MyUserDetailService myUserDetailService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final UploadImageUtil uploadImageUtil;
    private final ImageRepository imageRepository;
    
    public AuthServiceImp(UserRepository userRepository, MyUserDetailService myUserDetailService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, RoleRepository roleRepository, AuthenticationManager authenticationManager, UploadImageUtil uploadImageUtil, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.myUserDetailService = myUserDetailService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.uploadImageUtil = uploadImageUtil;
        this.imageRepository = imageRepository;
    }
    
    
    @Override
    public AuthenticationResponse signup(UserDataInput userDataInput) {
        // Check duplicate username
        User oldUser = userRepository.findByUsername(userDataInput.getUsername());
        if (oldUser != null) {
            throw new BadRequestException("Duplicate username");
        }
        //Create User
        //Upload file len cloudinary
        String imgLink = uploadImageUtil.getUrlFromFile(userDataInput.getAvatar());
        List<String> imgs = uploadImageUtil.getMultiUrl(userDataInput.getImages());

        User user = new User(userDataInput.getName(), userDataInput.getUsername(),
                             userDataInput.getPassword());
        List<Images> images = new ArrayList<>();
        for (String img:imgs){
            Images images1 = new Images(img,user);
            images.add(images1);
        }
        user.setAvatar(imgLink);
        user.setImages(images);
        user.setPassword(passwordEncoder.encode(userDataInput.getPassword()));
        userRepository.save(user);
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(List.of(role));
        List<User> users = role.getUsers();
        users.add(user);
        role.setUsers(users);
        roleRepository.save(role);
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(
                userDataInput.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwt, user.getId(), user.getUsername(),
                                          List.of(role.getName()));
    }
    
    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                                                            request.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new BadRequestException("Tai khoan hoac mat khau khong hop le");
        }
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(
                request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        User user = userRepository.findByUsername(request.getUsername());
        List<String> roles = new ArrayList<>();
        List<Role> roles1 = user.getRoles();
        if (roles1.size() > 0) {
            roles1.forEach(item -> roles.add(item.getName()));
        }
        return new AuthenticationResponse(jwt, user.getId(), user.getUsername(), roles);
    }
}
