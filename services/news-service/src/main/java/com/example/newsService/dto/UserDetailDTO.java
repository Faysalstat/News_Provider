package com.example.newsService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailDTO {
    private Long id;
    private String email;
    private List<String> preferences = new ArrayList<>();
}
