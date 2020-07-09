package com.gouzal.iquote.service;

import com.gouzal.iquote.model.Quote;
import com.gouzal.iquote.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuoteService implements IQuoteService {

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote findById(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quote with Id:" + id + " Not Found"));
    }

    @Override
    public List<Quote> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Page<Quote> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public void deleteById(long id) {
        this.repository.deleteById(id);
    }

    @Transactional
    public Quote save(Quote quote) {
        return this.repository.save(quote);
    }
}
