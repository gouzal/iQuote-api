package com.gouzal.iquote.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TagController {

    @GetMapping(value = "/index")
    public String index() {
        return "hello world";
    }
}
