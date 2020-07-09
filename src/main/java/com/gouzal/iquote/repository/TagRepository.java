package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
