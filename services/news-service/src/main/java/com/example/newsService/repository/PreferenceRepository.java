package com.example.newsService.repository;

import com.example.newsService.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreferenceRepository extends JpaRepository<Preference,Long> {
}
