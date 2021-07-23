package com.example.springrecipetest.controllers;

import com.example.springrecipetest.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() throws Exception {
        String  viewName = controller.getIndexPage(model);

        assertEquals("index" , viewName);
        Mockito.verify(recipeService, times(1)).getRecipes();
        Mockito.verify(model, times(1)).addAttribute(eq("recipes"), anySet());

    }


}