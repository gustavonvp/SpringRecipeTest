package com.example.springrecipetest.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode(exclude = {"recipe"})
public class UnitOfMeasure   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripton() {
        return description;
    }

    public void setDescripton(String descripton) {
        this.description = descripton;
    }
}
