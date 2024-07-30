package com.example.newsService.service;

import com.example.newsService.dto.NewsDTO;
import com.example.newsService.dto.ResponseDTO;
import com.example.newsService.dto.SummerizedResponse;

public interface SummarizerService {
    SummerizedResponse summarizeNewsContent(NewsDTO newsDTO);
}
