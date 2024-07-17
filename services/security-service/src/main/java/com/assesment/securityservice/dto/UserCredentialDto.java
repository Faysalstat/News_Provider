package com.assesment.securityservice.dto;


import com.assesment.securityservice.entity.Preference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialDto {
    Long id;
    String email;
    String password;
    List<Preference> preferences;
}
