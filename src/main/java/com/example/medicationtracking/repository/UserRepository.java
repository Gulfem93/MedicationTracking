package com.example.medicationtracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicationtracking.models.UserModels;

@Repository
public interface UserRepository extends JpaRepository<UserModels, Long> {
    Optional<UserModels> findByUserEmail(String userEmail);

    Optional<UserModels> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByUserEmail(String userEmail);

}
