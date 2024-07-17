package com.example.newsService.repository;

import com.example.newsService.model.UserCredential;
import com.example.newsService.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPreferenceRepository extends JpaRepository<UserPreference,Long> {
    Optional<List<UserPreference>> findAllByUserDetailId(Long id);
}
