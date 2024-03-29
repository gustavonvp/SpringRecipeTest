package com.example.springrecipetest.services;

import com.example.springrecipetest.commands.RecipeCommand;
import com.example.springrecipetest.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService  {

 Set<Recipe> getRecipes();
 Recipe findById(Long l);
 RecipeCommand saveRecipeCommand(RecipeCommand command);
 RecipeCommand findCommandById(Long l);
void deleteById(Long idToDelete);

}
