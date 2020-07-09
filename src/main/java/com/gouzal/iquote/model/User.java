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
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String image;
    private Boolean enable;
    private Boolean lock;
    @OneToMany(mappedBy = "user")
    List<Quote> quotes;

    @ManyToMany
    List<Tag> tags;

    @ManyToMany
    List<Author> authors;

    @ManyToMany
    List<Role> roles;
}
