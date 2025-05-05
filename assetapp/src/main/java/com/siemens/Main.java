package com.siemens;

import com.siemens.models.Customer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new
                ClassPathXmlApplicationContext("asset-config.xml");
    //IOC
    Customer customer = (Customer) context.getBean("customer");


    }
}