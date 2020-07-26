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
public class Quote {
    @ManyToMany
    List<Tag> tags;
    @ManyToOne
    User user;
    @ManyToOne
    Author author;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String citation;
    private boolean visible = true;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quote)) return false;
        Quote quote = (Quote) o;
        return getId() == quote.getId() &&
                Objects.equals(getCitation(), quote.getCitation()) &&
                Objects.equals(getAuthor(), quote.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCitation(), getAuthor());
    }*/
}
