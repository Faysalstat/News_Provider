package com.example.newsService.mapper;

import com.example.newsService.dto.UserCredentialDto;
import com.example.newsService.dto.UserDetailDTO;
import com.example.newsService.model.UserCredential;
import com.example.newsService.model.UserPreference;
import com.example.newsService.repository.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsMapper {
    @Autowired
    private UserPreferenceRepository userPreferenceRepository;
    public static UserCredential toEntity(UserCredentialDto dto){
        if(dto==null){
            return null;
        }
        UserCredential entity = new UserCredential();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }
    public static List<UserDetailDTO> toDto(List<UserCredential> entityList) {
        if (entityList == null) {
            return null;
        }
        List<UserDetailDTO> dtoList = new ArrayList<>();

        for(UserCredential entity: entityList){
            dtoList.add(UserDetailsMapper.toDto(entity));
        }
        return dtoList;
    }
    public static UserDetailDTO toDto(UserCredential entity){
        if(entity==null){
            return null;
        }
        UserDetailDTO dto = new UserDetailDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        return dto;
    }

//    public static List<UserPreference> toEntity(UserCredentialDto dto){
//        if(dto==null){
//            return null;
//        }
//        UserPreference entity = new UserPreference();
//        entity
//        return entity;
//    }
}
