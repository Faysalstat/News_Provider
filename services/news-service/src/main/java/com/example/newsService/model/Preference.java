package com.example.newsService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "preference")
@NoArgsConstructor
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String category;

    @OneToMany(mappedBy = "preference", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserPreference> userPreferences;
}
