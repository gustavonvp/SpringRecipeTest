package com.example.springrecipetest.services;

import com.example.springrecipetest.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService  {

 Set<Recipe> getRecipes();

}
