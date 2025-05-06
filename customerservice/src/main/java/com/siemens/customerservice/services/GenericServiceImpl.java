package com.siemens.customerservice.services;

import com.siemens.customerservice.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericServiceImpl<T> implements GenericService<T> {
    @Autowired
    private BaseRepository<T,String> baseRepository;

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
        return baseRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<T> findAll() {
        return baseRepository.findAll();
    }
}
