package com.gouzal.iquote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String citation;
    private boolean visible = true;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToMany
    List<Tag> tags;

    @ManyToOne
    User user;

    @ManyToOne
    User author;

    @Override
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
    }
}
