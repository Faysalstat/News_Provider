package com.assesment.securityservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_preference")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_detail_id")
    private UserCredential userDetail;

    @ManyToOne
    @JoinColumn(name = "preference_id")
    private Preference preference;
}
