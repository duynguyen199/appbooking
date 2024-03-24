package org.example.buoi3.services;

import org.example.buoi3.outputs.UserDataOutput;

public interface UserService {
    UserDataOutput getDetail(Long id);
}
