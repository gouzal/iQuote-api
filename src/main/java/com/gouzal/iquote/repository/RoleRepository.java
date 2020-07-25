package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Modifying
    @Query(value = "truncate table role CASCADE", nativeQuery = true)
    @Transactional
    void truncate();
}
