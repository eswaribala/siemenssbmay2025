package com.siemens.customerservice.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_Id")
    private long customerId;

    @Embedded
    private FullName fullName;

    @Column(name = "Email",nullable = false,length = 150)
    private String email;

    @Column(name = "Phone_Number",nullable = false,length = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender",nullable = false,length = 15)
    private Gender gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "Date_Of_Birth",nullable = false)
    private LocalDate dateOfBirth;
}
