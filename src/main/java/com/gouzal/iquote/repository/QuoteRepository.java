package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
