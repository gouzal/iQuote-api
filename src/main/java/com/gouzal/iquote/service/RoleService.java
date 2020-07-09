package com.gouzal.iquote.service;

import com.gouzal.iquote.model.Role;
import com.gouzal.iquote.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository repository;


    public Role findById(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role with Id:" + id + " Not Found"));
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Role save(Role role) {
        return this.repository.save(role);
    }


    @Override
    public void deleteById(long id) {
        throw new RuntimeException("unsupported Operation");
    }


}
