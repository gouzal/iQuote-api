package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Modifying
    @Query(value = "truncate table author", nativeQuery = true)
    void truncate();
}
