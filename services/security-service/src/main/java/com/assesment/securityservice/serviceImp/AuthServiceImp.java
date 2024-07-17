package com.assesment.securityservice.serviceImp;

import com.assesment.securityservice.dto.*;
import com.assesment.securityservice.entity.Preference;
import com.assesment.securityservice.entity.UserCredential;
import com.assesment.securityservice.entity.UserPreference;
import com.assesment.securityservice.exception.OperationFailedException;
import com.assesment.securityservice.mapper.UserCredentialMapper;
import com.assesment.securityservice.repository.PreferenceRepository;
import com.assesment.securityservice.repository.UserCredentialRepository;
import com.assesment.securityservice.service.AuthService;
import com.assesment.securityservice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private UserCredentialRepository userRepo;
    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtService jwtService;

    @Override
    public String saveUser(UserCredentialDto userCredentialDto) throws OperationFailedException {
        if(userRepo.findByEmail(userCredentialDto.getEmail()).isPresent()){
            throw new OperationFailedException("User Already Exists");
        }
        userCredentialDto.setPassword(passwordEncoder.encode(userCredentialDto.getPassword()));
        try {
            UserCredential user = userRepo.save(UserCredentialMapper.toCreateEntity(userCredentialDto));
            for (Preference preference: userCredentialDto.getPreferences()) {
                UserPreference userPreference = new UserPreference();
                userPreference.setPreference(preference);
                userPreference.setUserDetail(user);
                preferenceRepository.save(userPreference);
            }

        }catch (Exception e){
            return "user added to the system failed";
        }
        return "user added to the system";
    }

    @Override
    public LoginResponse generateToken(String username) {
        UserCredential userCredential = userRepo.findByEmail(username).orElseThrow();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtService.generateToken(userCredential));
        loginResponse.setUserName(userCredential.getEmail());
        return loginResponse;
    }

    @Override
    public Boolean validateToken(String token) {
        try{
            jwtService.validateToken(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserCredentialDto getUserByUserName(String username) {
        UserCredentialDto userCredentialDto = UserCredentialMapper.toDto(userRepo.findByEmail(username).orElseThrow());
//        userCredentialDto.setPreferences(UserCredentialMapper.toPreferenceDto(preferenceRepository.findAllByUserId(userCredentialDto.getId()).orElseThrow()));
        return userCredentialDto;
    }
}
