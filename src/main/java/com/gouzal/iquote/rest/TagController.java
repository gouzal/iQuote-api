package com.gouzal.iquote.rest;

import com.gouzal.iquote.model.Tag;
import com.gouzal.iquote.service.Impl.TagService;
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
public class TagController {
    final
    TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(value = "/api/tags")
    public ResponseEntity<List<Tag>> list() {
        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/tags/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tag> byId(@PathVariable long id) {
        return new ResponseEntity<>(tagService.findById(id), HttpStatus.OK);
    }
}
