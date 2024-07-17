package com.example.newsService.serviceImp;

import com.example.newsService.dto.NewsDTO;
import com.example.newsService.dto.RequestDTO;
import com.example.newsService.dto.ResponseDTO;
import com.example.newsService.service.SummarizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class SummarizerServiceImp implements SummarizerService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public NewsDTO summarizeNewsContent(NewsDTO newsDTO) {
        RequestDTO requestDTO = new RequestDTO();
        String content = newsDTO.getDescription();
        requestDTO.setLanguage("en");
        requestDTO.setMax_length(50);
        requestDTO.setMin_length(5);
        requestDTO.setText(content);
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().add(
                    "X-API-KEY",
                    "QCSDQTdMxOBuNCQYTFLkBvfMRuSRrjsDwTHaBmjmojbGQFMQof");
            return execution.execute(request,body);
        }));
        ResponseDTO responseDTO = restTemplate.postForObject(
                "https://portal.ayfie.com/api/summarize",requestDTO, ResponseDTO.class);
        assert responseDTO != null;
        newsDTO.setDescription(responseDTO.getResult());
        String daprUrl = "http://localhost:3500/v1.0/publish/pubsub/mytopic";
        restTemplate.postForObject(daprUrl, newsDTO, NewsDTO.class);
        return newsDTO;
    }
}
