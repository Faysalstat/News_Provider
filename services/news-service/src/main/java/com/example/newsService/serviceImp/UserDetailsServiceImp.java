package com.example.newsService.serviceImp;

import com.example.newsService.dto.UserDetailDTO;
import com.example.newsService.mapper.UserDetailsMapper;
import com.example.newsService.model.UserPreference;
import com.example.newsService.repository.UserCredentialRepository;
import com.example.newsService.repository.UserPreferenceRepository;
import com.example.newsService.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserPreferenceRepository userPreferenceRepository;
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Override
    public List<UserDetailDTO> getAllUserDetails() {
        List<UserDetailDTO> userDetailDTOS = UserDetailsMapper.toDto(userCredentialRepository.findAll());
        for(UserDetailDTO user: userDetailDTOS){
            List<UserPreference> userPreferences = userPreferenceRepository.findAllByUserDetailId(user.getId()).orElseThrow();
            for(UserPreference preference: userPreferences){
                user.getPreferences().add(preference.getPreference().getCategory());
            }
        }
        return userDetailDTOS;
    }
}
