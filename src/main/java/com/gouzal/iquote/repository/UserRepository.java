package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "truncate table \"users\" CASCADE", nativeQuery = true)
    @Transactional
    void truncate();

    // User findFirstByLogin(String login);
    User findByUserName(String userName);
}
