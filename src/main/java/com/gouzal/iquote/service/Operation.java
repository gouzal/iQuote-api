package com.gouzal.iquote.service;

import java.util.List;

public interface Operation<T> {
     List<T> findAll();

     T findById(long id);

     T save(T instance);

     void deleteById(long id);
}
