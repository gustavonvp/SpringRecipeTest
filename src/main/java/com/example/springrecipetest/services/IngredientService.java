package com.example.springrecipetest.services;

import com.example.springrecipetest.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    void deleteById(Long recipeId, Long idToDelete);
}
