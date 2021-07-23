package com.example.springrecipetest.domain;


import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Assertions;


class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp() {
          category = new Category();
    }

    @Test
    void getId() throws Exception {
        Long idValue = 4L;
        category.setId(idValue);
        Assertions.assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() throws Exception {
        String descriptionValue = "Testing Properties description in category class";
        category.setDescription(descriptionValue);
        Assertions.assertEquals(descriptionValue, category.getDescription());
    }

    @Test
    void setDescription() throws  Exception {
    }
}