package com.example.newsService.service;

import com.example.newsService.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    NewsDTO getNewsContent(List<String> preferences);
}
