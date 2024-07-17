package com.assesment.securityservice.service;

import com.assesment.securityservice.dto.LoginResponse;
import com.assesment.securityservice.dto.UserCredentialDto;
import com.assesment.securityservice.exception.OperationFailedException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String saveUser(UserCredentialDto credential) throws OperationFailedException;
    LoginResponse generateToken(String username);
    Boolean validateToken(String token);

    UserCredentialDto getUserByUserName(String username);
}
