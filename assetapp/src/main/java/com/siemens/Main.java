package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.models.Customer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new
                ClassPathXmlApplicationContext("asset-config.xml");
    //IOC
    Customer customer = (Customer) context.getBean("customer-instance");
    Faker faker = new Faker();
    //DI
     customer.setId(faker.number().numberBetween(10000,10000000));
     customer.setName(faker.name().fullName());
     customer.setAddress(faker.address().fullAddress());
     customer.setEmail(faker.internet().emailAddress());
     customer.setPhone(faker.phoneNumber().phoneNumber());

     //show customer data
        System.out.println(customer);

    }
}