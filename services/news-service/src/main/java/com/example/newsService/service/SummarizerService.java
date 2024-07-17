package com.example.newsService.service;

import com.example.newsService.dto.NewsDTO;

public interface SummarizerService {
    NewsDTO summarizeNewsContent(NewsDTO newsDTO);
}
