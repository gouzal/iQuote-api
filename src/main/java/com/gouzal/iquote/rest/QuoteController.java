package com.gouzal.iquote.rest;

import com.gouzal.iquote.model.Quote;
import com.gouzal.iquote.service.Impl.QuoteService;
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
public class QuoteController {
    final
    QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(value = "/api/quotes")
    public ResponseEntity<List<Quote>> list() {
        return new ResponseEntity<>(quoteService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/quotes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quote> byId(@PathVariable long id) {
        return new ResponseEntity<>(quoteService.findById(id), HttpStatus.OK);
    }
}
