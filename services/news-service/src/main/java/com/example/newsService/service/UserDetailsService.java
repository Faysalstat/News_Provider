package com.example.newsService.service;

import com.example.newsService.dto.UserDetailDTO;

import java.util.List;

public interface UserDetailsService {
    List<UserDetailDTO> getAllUserDetails();
}
