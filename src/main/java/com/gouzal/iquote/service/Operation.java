package com.gouzal.iquote.service;

import java.util.List;
import java.util.Optional;

public interface Operation<T> {
     List<T> findAll();

     Optional<T> findById(Long id);

     void save(T instance);

     void deleteById(Long id);
}
