package com.gouzal.iquote.rest;

import com.gouzal.iquote.model.Tag;
import com.gouzal.iquote.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping(value = "/api/tags")
    public ResponseEntity<List> list() {
        return new ResponseEntity<List>(tagService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/tags/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tag> byId(@PathVariable long id) {
        return new ResponseEntity<Tag>(tagService.findById(id), HttpStatus.OK);
    }
}
