package com.gouzal.iquote.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "\"user\"")
public class User {
    @ManyToMany
    @JsonIgnore
    List<Tag> tags;
    @ManyToMany
    @JsonIgnore
    List<Author> authors;
    @ManyToMany
    @JsonIgnore
    List<Role> roles;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthdayDate;
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Quote> quotes;
    private String image;
    private Boolean enable;
    private Boolean lock;
}
