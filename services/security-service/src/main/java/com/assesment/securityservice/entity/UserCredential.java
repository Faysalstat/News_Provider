package com.assesment.securityservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "user_details")
@NoArgsConstructor
public class UserCredential implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String email;
    @Column
    private String password;

    @OneToMany(mappedBy = "userDetail", cascade = CascadeType.ALL)
    private Set<UserPreference> userPreferences;

}
