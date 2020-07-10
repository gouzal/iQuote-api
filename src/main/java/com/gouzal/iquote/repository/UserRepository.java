package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   // User findFirstByLogin(String login);
}
