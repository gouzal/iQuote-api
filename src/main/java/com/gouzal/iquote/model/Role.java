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
public class Role {
    @ManyToMany
    List<User> users;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Long;
    private String label;
}
