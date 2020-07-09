package com.gouzal.iquote.service;

import com.gouzal.quotes.models.Quote;
import com.gouzal.quotes.models.Tag;
import com.gouzal.quotes.repositories.IQuoteRepository;
import com.gouzal.quotes.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TagService implements ITagService {

    @Autowired
    private ITagRepository repository;

    @Autowired
    private IQuoteRepository quoteRepository;

    public Tag findById(int id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag with Id:" + id + " Not Found"));
    }

    @Override
    public List<Tag> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return this.repository.save(tag);
    }

    @Override
    public void deleteById(int id) {
        throw new RuntimeException("unsupported Operation");
    }

    @Override
    public List<Tag> findByQuote(int quoteId) {
        Quote quote = this.quoteRepository.findById(quoteId)
                .orElseThrow(() -> new EntityNotFoundException("Quote with Id:" + quoteId + " Not Found"));

        return quote.getTags();
    }


}
