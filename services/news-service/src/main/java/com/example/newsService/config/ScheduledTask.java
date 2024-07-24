package com.example.newsService.config;

import com.example.newsService.dto.NewsDTO;
import com.example.newsService.dto.UserDetailDTO;
import com.example.newsService.service.NewsService;
import com.example.newsService.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class ScheduledTask {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserDetailsService userDetailsService;

    public ScheduledTask() {
    }

    @Scheduled(fixedRate = 600000)
    public void callApi() {
        List<UserDetailDTO> users = userDetailsService.getAllUserDetails();
        for(UserDetailDTO user: users){
            List<NewsDTO> newsDTOs =  newsService.getNewsContent(user.getPreferences());
        }
    }
}
