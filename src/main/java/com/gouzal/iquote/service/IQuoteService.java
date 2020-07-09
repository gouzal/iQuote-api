package com.gouzal.iquote.service;

import com.gouzal.iquote.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuoteService extends Operation<Quote> {

    /*
    public Quote findbById(int id);
    public List<Quote> findAll();
    public Page<Quote> findAll(Pageable pageable);
    public void deleteById(int id);
    public Quote save(Quote quote);
     */
    public Page<Quote> findAll(Pageable pageable);
}
