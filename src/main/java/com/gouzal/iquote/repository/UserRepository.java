package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // User findFirstByLogin(String login);
    User findByUserName(String userName);
}
