package com.example.springrecipetest.services;

import com.example.springrecipetest.commands.UnitOfMeasureCommand;
import com.example.springrecipetest.converters.IngredientCommandToIngredient;
import com.example.springrecipetest.converters.IngredientToIngredientCommand;

import com.example.springrecipetest.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.example.springrecipetest.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.springrecipetest.repository.RecipeRepository;
import com.example.springrecipetest.repository.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.springrecipetest.domain.Ingredient;
import com.example.springrecipetest.domain.Recipe;
import java.util.Optional;
import com.example.springrecipetest.commands.IngredientCommand;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    IngredientService ingredientService;

    //init converters
    IngredientServiceImplTest() {
        this.ingredientToIngredientCommand =  new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient( new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient, recipeRepository, unitOfMeasureRepository);
    }


        @Test
        public void findByRecipeIdAndReceipeIdHappyPath() throws Exception {
            //given
            Recipe recipe = new Recipe();
            recipe.setId(1L);

            Ingredient ingredient1 = new Ingredient();
            ingredient1.setId(1L);

            Ingredient ingredient2 = new Ingredient();
            ingredient2.setId(1L);

            Ingredient ingredient3 = new Ingredient();
            ingredient3.setId(3L);

            recipe.addIngredient(ingredient1);
            recipe.addIngredient(ingredient2);
            recipe.addIngredient(ingredient3);
            Optional<Recipe> recipeOptional = Optional.of(recipe);

            when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

            //then
            IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

            //when
            assertEquals(Long.valueOf(3L), ingredientCommand.getId());
            assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
            verify(recipeRepository, times(1)).findById(anyLong());
        }

    @Test
    void findByRecipeIdAndIngredientId() throws Exception {}
}