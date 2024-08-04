package com.example.mailService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewsDTO {
    private String title;
    private String link;
    private String description;
    private String receiver;
}
