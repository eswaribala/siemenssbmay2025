package com.siemens.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("customer-instance")
public class Customer {

    private long id;
    private String name;
    private String address;
    private String phone;
    private String email;


}
