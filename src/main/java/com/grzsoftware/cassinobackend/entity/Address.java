package com.grzsoftware.cassinobackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "adress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "neighborhood", nullable = false)
    private String neighbourhood;

    @Column(name = "zip_code", nullable = false)
    private String zip;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToOne(mappedBy = "adress")
    private User user;
}
