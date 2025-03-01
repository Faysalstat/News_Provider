package com.example.newsService.config;

import com.example.newsService.dto.NewsDTO;
import com.example.newsService.dto.ResponseDTO;
import com.example.newsService.dto.SummerizedResponse;
import com.example.newsService.dto.UserDetailDTO;
import com.example.newsService.service.NewsService;
import com.example.newsService.service.SummarizerService;
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
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SummarizerService summarizerService;

    public ScheduledTask() {
    }

    @Scheduled(fixedRate = 3600000)
    public void callApi() throws Exception {
        List<UserDetailDTO> users = userDetailsService.getAllUserDetails();
        for(UserDetailDTO user: users){
            List<NewsDTO> newsDTOs =  newsService.getNewsContent(user.getPreferences());
            NewsDTO firstNews = newsDTOs.get(0);
            SummerizedResponse summerizedNews = summarizerService.summarizeNewsContent(firstNews);
            NewsDTO newsForPublish = new NewsDTO();
            newsForPublish.setDescription(summerizedNews.getResult());
            newsForPublish.setTitle(firstNews.getTitle());
            newsForPublish.setLink(firstNews.getLink());
            newsForPublish.setReceiver(user.getEmail());
            String daprUrl = "http://localhost:3500/v1.0/publish/pubsub/mytopic";
            restTemplate.postForObject(daprUrl,newsForPublish, String.class);
            System.out.println("Message Sent Successfully");
        }
    }
}
