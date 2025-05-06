package com.siemens.customerservice.controllers;

import com.siemens.customerservice.dtos.Corporate;
import com.siemens.customerservice.dtos.Individual;
import com.siemens.customerservice.dtos.ResponseWrapper;
import com.siemens.customerservice.models.CorporateCustomer;
import com.siemens.customerservice.models.FullName;
import com.siemens.customerservice.models.IndividualCustomer;
import com.siemens.customerservice.repositories.CorporateRepository;
import com.siemens.customerservice.services.CorporateCustomerService;
import com.siemens.customerservice.services.IndividualCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private IndividualCustomerService individualCustomerService;
    @Autowired
    private CorporateCustomerService corporateCustomerService;

    //save individual

    @PostMapping("/indvidualcustomers/v1.0")
    public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){

        IndividualCustomer individualObj = IndividualCustomer.builder()
                .customerId(individual.getCustomerId())
                .email(individual.getEmail())
                .phoneNumber(individual.getPhoneNumber())
                .active(individual.isActive())
                .dateOfBirth(individual.getDateOfBirth())
                .build();

         IndividualCustomer individualCustomerResponse= this.individualCustomerService.save(individualObj);
         if(individualCustomerResponse!=null){
             return ResponseEntity.status(HttpStatus.CREATED).body(new
                     ResponseWrapper<IndividualCustomer>(individualCustomerResponse));
         }else
         {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                     .body(new ResponseWrapper("Invalid Input"));
         }



    }
    @PostMapping("/corporatecustomers/v1.0")
    public ResponseEntity<ResponseWrapper> addCorporate(@RequestBody Corporate corporate){

        CorporateCustomer corporateObj = CorporateCustomer.builder()
                .customerId(corporate.getCustomerId())
                .email(corporate.getEmail())
                .phoneNumber(corporate.getPhoneNumber())
                .active(corporate.isActive())

                .build();

        CorporateCustomer corporateCustomerResponse=
                this.corporateCustomerService.save(corporateObj);
        if(corporateCustomerResponse!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(new
                    ResponseWrapper<CorporateCustomer>(corporateCustomerResponse));
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Invalid Input"));
        }



    }



}
