package com.example.springrecipetest.services;

import com.example.springrecipetest.commands.RecipeCommand;
import com.example.springrecipetest.converters.RecipeCommandToRecipe;
import com.example.springrecipetest.converters.RecipeToRecipeCommand;
import com.example.springrecipetest.domain.Recipe;
import com.example.springrecipetest.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
class RecipeServiceTest {


    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRecipes() {
    }

    @Transactional
    @Test
    public void testSaveOfDescription() throws Exception {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        Assertions.assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
        Assertions.assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        Assertions.assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
    }
}