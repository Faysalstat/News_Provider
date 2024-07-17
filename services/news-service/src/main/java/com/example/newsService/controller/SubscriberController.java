package com.example.newsService.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dapr/subscribe")
public class SubscriberController {
    @PostMapping("/mytopic")
    public void handleMessage(@RequestBody String message) {
        System.out.println("Received message: " + message);
        // Process the message
    }
}