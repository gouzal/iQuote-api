package com.gouzal.iquote.service;

import com.gouzal.iquote.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuoteService extends Operation<Quote> {

    public Page<Quote> findAll(Pageable pageable);
}
