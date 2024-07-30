package com.example.newsService.serviceImp;

import com.example.newsService.dto.NewsDTO;
import com.example.newsService.dto.ResponseDTO;
import com.example.newsService.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class NewsServiceImp implements NewsService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<NewsDTO> getNewsContent(List<String> preferences) throws Exception {
        try{
            String url = "https://newsdata.io/api/1/latest"; // Replace with your API URL
            URI uri = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", "pub_485357e364b279ba3fb92729ea004c3f609f7")
                    .queryParam("q", preferences.get(0))
                    .queryParam("language","en")
                    .build()
                    .toUri();
            ResponseDTO responseDTO = restTemplate.getForObject(uri, ResponseDTO.class);
            assert responseDTO != null;
            return responseDTO.getResults();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }
}
