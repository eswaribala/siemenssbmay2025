package com.siemens.customerservice.services;

import com.siemens.customerservice.exceptions.CustomerNotFoundException;
import com.siemens.customerservice.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @CachePut(cacheNames = "customers")
    public T update(T entity) {
     return baseRepository.save(entity);
    }

    @Override
    @CacheEvict(cacheNames = "customers")
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
    @Cacheable(cacheNames = "customers")
    public Iterable<T> findAll() {
        return baseRepository.findAll();
    }
}
