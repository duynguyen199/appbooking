package org.example.buoi3.services.imp;

import org.example.buoi3.exception.NotFoundException;
import org.example.buoi3.models.User;
import org.example.buoi3.outputs.UserDataOutput;
import org.example.buoi3.repositories.UserRepository;
import org.example.buoi3.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    
    private final UserRepository userRepository;
    
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDataOutput getDetail(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw  new NotFoundException("No user");
        }
        return new UserDataOutput(user.get().getUsername(),
                                  user.get().getAvatar());
    }
}
