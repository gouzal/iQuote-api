package com.gouzal.iquote.service.Impl;

import com.gouzal.iquote.model.Quote;
import com.gouzal.iquote.model.Tag;
import com.gouzal.iquote.repository.QuoteRepository;
import com.gouzal.iquote.repository.TagRepository;
import com.gouzal.iquote.service.operation.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TagService implements ITagService {

    @Autowired
    private TagRepository repository;

    @Autowired
    private QuoteRepository quoteRepository;

    public Tag findById(long id) {
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
    public void deleteById(long id) {
        throw new RuntimeException("unsupported Operation");
    }

    @Override
    public List<Tag> findByQuote(long quoteId) {
        Quote quote = this.quoteRepository.findById(quoteId)
                .orElseThrow(() -> new EntityNotFoundException("Quote with Id:" + quoteId + " Not Found"));

        return quote.getTags();
    }


}
