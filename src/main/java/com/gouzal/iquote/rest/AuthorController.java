package com.gouzal.iquote.rest;

import com.gouzal.iquote.model.Author;
import com.gouzal.iquote.service.Impl.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class AuthorController {
    final
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/api/authors")
    public ResponseEntity<List<Author>> list() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/authors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> byId(@PathVariable long id) {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }
}
