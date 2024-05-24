package com.grzsoftware.cassinobackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    @NotNull(message = "username must not be null")
    @Size(min = 3, max = 15)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @NotNull
    @Email
    private String email;

    @Column(name = "pass")
    @NotNull
    private String password;

    @Column(name = "cpf", unique = true, nullable = false)
    @NotNull(message = "cpf must not be null")
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "birth_date", nullable = false)
    @NotNull(message = "birth date must not be null")
    private LocalDate birthDate;

    @Column(name = "balance")
    private double balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
