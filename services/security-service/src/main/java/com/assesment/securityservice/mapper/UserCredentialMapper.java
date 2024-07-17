package com.assesment.securityservice.mapper;

import com.assesment.securityservice.dto.UserCredentialDto;
import com.assesment.securityservice.entity.Preference;
import com.assesment.securityservice.entity.UserCredential;
import com.assesment.securityservice.entity.UserPreference;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCredentialMapper {

    public static UserCredentialDto toDto(UserCredential entity) {
        if (entity == null) {
            return null;
        }
        UserCredentialDto dto = new UserCredentialDto();
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static UserCredential toCreateEntity(UserCredentialDto dto) {
        if (dto == null) {
            return null;
        }
        UserCredential entity = new UserCredential();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }
    public static UserCredential toUpdateEntity(UserCredentialDto dto) {
        if (dto == null) {
            return null;
        }

        UserCredential entity = new UserCredential();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }


    public static List<String> toPreferenceDto(List<Preference> preferences){
        if(preferences == null || preferences.size()==0){
            return null;
        }
        List<String>  list= new ArrayList<>();
        for (Preference preference: preferences) {
            list.add(preference.getCategory());
        }
        return list;
    }

}
