package com.example.newsService.serviceImp;

import com.example.newsService.dto.NewsDTO;
import com.example.newsService.dto.RequestDTO;
import com.example.newsService.dto.ResponseDTO;
import com.example.newsService.dto.SummerizedResponse;
import com.example.newsService.service.SummarizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SummarizerServiceImp implements SummarizerService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public SummerizedResponse summarizeNewsContent(NewsDTO newsDTO) {
        RequestDTO requestDTO = new RequestDTO();
        String content;
        if(newsDTO.getDescription()== null){
            content= newsDTO.getTitle();
        }else{
            content = newsDTO.getDescription();
        }
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
        SummerizedResponse response = new SummerizedResponse();
        try {
            response = restTemplate.postForObject(
                    "https://portal.ayfie.com/api/summarize",requestDTO, SummerizedResponse.class);
        }catch (Exception e) {
            return response;
        }

        return response;
    }
}
