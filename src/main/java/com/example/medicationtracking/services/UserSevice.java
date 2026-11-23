package com.example.medicationtracking.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.medicationtracking.models.UserModels;
import com.example.medicationtracking.repository.UserRepository;

@Service
public class UserSevice implements UserDetailsService {

    private final UserRepository userRepository;

    public UserSevice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserModels user = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + userEmail));

        return User.withUsername(user.getUserEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
