package com.gouzal.iquote.rest;

import com.gouzal.iquote.model.Role;
import com.gouzal.iquote.service.Impl.RoleService;
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
public class RoleController {
    final
    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/api/roles")
    public ResponseEntity<List<Role>> list() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> byId(@PathVariable long id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }
}
