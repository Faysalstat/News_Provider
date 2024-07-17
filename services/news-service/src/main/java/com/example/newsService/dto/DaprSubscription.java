package com.example.newsService.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DaprSubscription {
    private String pubSubName;
    private String topic;
    private String route;

}
