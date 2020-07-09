package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
