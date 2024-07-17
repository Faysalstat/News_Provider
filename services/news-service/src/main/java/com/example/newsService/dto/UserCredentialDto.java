package com.example.newsService.dto;


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
    private Long id;
    private String email;
    private String password;
    private List<String> preferences;
}
