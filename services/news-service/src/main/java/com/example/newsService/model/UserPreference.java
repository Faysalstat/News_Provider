package com.example.newsService.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_preference")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_detail_id")
    private UserCredential userDetail;

    @ManyToOne
    @JoinColumn(name = "preference_id")
    private Preference preference;
}
