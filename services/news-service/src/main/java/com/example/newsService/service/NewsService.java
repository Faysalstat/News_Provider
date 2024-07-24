package com.example.newsService.service;

import com.example.newsService.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    List<NewsDTO> getNewsContent(List<String> preferences);
}
