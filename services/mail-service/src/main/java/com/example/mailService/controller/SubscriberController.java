package com.example.mailService.controller;

import com.example.mailService.dto.NewsDTO;
import com.example.mailService.model.Message;
import com.example.mailService.service.EmailSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subscribe")
public class SubscriberController {
    @Autowired
    private EmailSenderService emailSenderService;
    @Topic(name = "mytopic", pubsubName = "pubsub")
    @PostMapping(path = "/mytopic")
    public Mono<Void> getCheckout(@RequestBody(required = false) CloudEvent<NewsDTO> cloudEvent) {
        return Mono.fromRunnable(() -> {
            try {
            ObjectMapper objectMapper = new ObjectMapper();

            NewsDTO newsDTO = cloudEvent.getData();
            if(newsDTO.getDescription()!=null){
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(newsDTO.getReceiver());
                mailMessage.setSubject(newsDTO.getTitle());
                mailMessage.setFrom("information@dalilinaure.com");
                mailMessage.setText(newsDTO.getDescription());
                emailSenderService.sendEmail(mailMessage);
            }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}