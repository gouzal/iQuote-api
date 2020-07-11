package com.gouzal.iquote.service.Impl;

import com.gouzal.iquote.model.User;
import com.gouzal.iquote.repository.UserRepository;
import com.gouzal.iquote.service.operation.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    public User findById(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with Id:" + id + " Not Found"));
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        throw new RuntimeException("unsupported Operation");
    }

    /*@Override
    public User findFirstByLogin(String login) {
        return this.repository.findFirstByLogin(login);
    }*/
}
