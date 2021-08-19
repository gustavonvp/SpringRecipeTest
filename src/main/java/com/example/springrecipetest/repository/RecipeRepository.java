package com.example.springrecipetest.repository;

import com.example.springrecipetest.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
