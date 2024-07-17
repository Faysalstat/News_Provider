package com.example.mailService.controller;

import com.example.mailService.dto.NewsDTO;
import com.example.mailService.model.Message;
import com.example.mailService.service.EmailSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscribe")
public class SubscriberController {
    @Autowired
    private EmailSenderService emailSenderService;
    @PostMapping("/mytopic")
    public void handleMessage(@RequestBody NewsDTO news) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("faysalstat04@gmail.com");
            mailMessage.setSubject(news.getTitle());
            mailMessage.setFrom("information@dalilinaure.com");
            mailMessage.setText(news.getDescription());
            emailSenderService.sendEmail(mailMessage);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}