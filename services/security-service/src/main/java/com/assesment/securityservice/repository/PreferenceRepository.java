package com.assesment.securityservice.repository;

import com.assesment.securityservice.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PreferenceRepository extends JpaRepository<UserPreference,Long> {
}
