package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.domain.Product;

public interface CRUDService<T> {

    List<?>listAll();

    Optional<T> getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);

}
