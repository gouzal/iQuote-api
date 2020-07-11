package com.gouzal.iquote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "tags")
    List<Quote> quotes;*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return getId() == tag.getId() &&
                Objects.equals(getValue(), tag.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue());
    }*/
}
