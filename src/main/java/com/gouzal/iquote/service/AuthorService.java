package com.gouzal.iquote.service;

import com.gouzal.iquote.model.Author;
import com.gouzal.iquote.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository repository;


    public Author findById(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with Id:" + id + " Not Found"));
    }

    @Override
    public List<Author> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Author save(Author author) {
        return this.repository.save(author);
    }


    @Override
    public void deleteById(long id) {
        throw new RuntimeException("unsupported Operation");
    }


}
