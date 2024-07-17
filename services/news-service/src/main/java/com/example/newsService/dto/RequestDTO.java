package com.example.newsService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestDTO {
    String language;
    String text;
    Integer min_length;
    Integer max_length;
}
