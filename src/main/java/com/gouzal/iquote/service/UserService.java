package com.gouzal.iquote.service;

import com.gouzal.quotes.models.User;
import com.gouzal.quotes.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;


    public User findById(int id) {
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
    public void deleteById(int id) {
        throw new RuntimeException("unsupported Operation");
    }

    @Override
    public User findFirstByLogin(String login) {
        return this.repository.findFirstByLogin(login);
    }
}
