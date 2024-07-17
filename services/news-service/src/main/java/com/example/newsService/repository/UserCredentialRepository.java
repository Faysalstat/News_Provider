package com.example.newsService.repository;

import com.example.newsService.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserCredentialRepository  extends JpaRepository<UserCredential,Long> {
    Optional<UserCredential> findByEmail(String username);
}
