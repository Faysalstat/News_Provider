package com.example.newsService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/news/pubsub")
public class PublisherController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/publish")
    public String publishMessage(@RequestBody String message) {
        String daprUrl = "http://localhost:3500/v1.0/publish/pubsub/mytopic";
        restTemplate.postForObject(daprUrl, message, String.class);
        return "Message published";
    }

}
