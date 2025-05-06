package com.siemens.customerservice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "Address_Id")
    private long addressId;
    @Column(name = "Street_Name",nullable = false,length = 150)
    private String streetName;
    @Column(name = "City",nullable = false,length = 50)
    private String city;
    @Column(name = "State",nullable = false,length = 50)
    private String state;
    @Column(name = "Country",nullable = false,length = 50)
    private String country;
    @Column(name = "Postal_Code",nullable = false,length = 10)
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"),name="Customer_Id_FK")
    private Customer customer;

}
