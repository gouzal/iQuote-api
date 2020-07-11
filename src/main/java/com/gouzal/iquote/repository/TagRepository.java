package com.gouzal.iquote.repository;

import com.gouzal.iquote.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Modifying
    @Query(value = "truncate table tag", nativeQuery = true)
    void truncate();
}
