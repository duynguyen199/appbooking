package org.example.buoi3.services;

import org.example.buoi3.inputs.AuthenticationRequest;
import org.example.buoi3.inputs.UserDataInput;
import org.example.buoi3.outputs.auth.AuthenticationResponse;

import java.io.IOException;

public interface AuthService {
    AuthenticationResponse signup(UserDataInput userDataInput) throws IOException;
    AuthenticationResponse login(AuthenticationRequest request);
}
