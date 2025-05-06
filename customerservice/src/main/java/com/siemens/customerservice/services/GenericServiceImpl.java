package com.siemens.customerservice.services;

import com.siemens.customerservice.exceptions.CustomerNotFoundException;
import com.siemens.customerservice.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {
    //@Autowired
    private final BaseRepository<T,String> baseRepository;

    public GenericServiceImpl(BaseRepository<T,String> baseRepository) {
        this.baseRepository=baseRepository;
    }

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public T update(T entity) {
     return baseRepository.save(entity);
    }

    @Override
    public boolean delete(T entity) {
      boolean status=false;
      if(entity!=null){
          baseRepository.delete(entity);
          status=true;
      }
      return status;
    }

    @Override
    public T findById(String id) {
        return baseRepository.findById(id).orElseThrow(()->
                new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public Iterable<T> findAll() {
        return baseRepository.findAll();
    }
}
