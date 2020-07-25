package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Modifying
    @Query(value = "truncate table quote CASCADE", nativeQuery = true)
    @Transactional
    void truncate();
}
