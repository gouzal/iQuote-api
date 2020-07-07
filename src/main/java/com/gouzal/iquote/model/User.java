package com.gouzal.iquote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String email;
    private String image;
    @OneToMany(mappedBy = "user")
    List<Quote> quotes;

    @ManyToMany
    List<Tag> tags;

    @ManyToMany
    List<Author> authors;
}
