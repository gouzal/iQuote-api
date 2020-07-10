package com.gouzal.iquote.rest;

import com.gouzal.iquote.model.Quote;
import com.gouzal.iquote.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class QuoteController {
    final
    QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(value = "/api/quotes")
    public ResponseEntity<List> list() {
        return new ResponseEntity<List>(quoteService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/quotes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quote> byId(@PathVariable long id) {
        return new ResponseEntity<Quote>(quoteService.findById(id), HttpStatus.OK);
    }
}
