package com.example.medicationtracking.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usersid;

    @Column
    private String userName;

    @Column
    private String userSurname;

    @Column
    @NotBlank
    @Email
    private String userEmail;

    @Column
    @NotEmpty
    @NotBlank
    private String password;

}
