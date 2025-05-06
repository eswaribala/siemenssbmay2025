package com.siemens.customerservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FullName {
    @Column(name = "First_Name",nullable = false,length = 50)
    private String firstName;
    @Column(name = "Last_Name",nullable = false,length = 50)
    private String lastName;
    @Column(name = "Middle_Name",length = 50)
    private String middleName;
}
