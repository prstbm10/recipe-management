package com.lets.cook.demo.service;

import com.lets.cook.demo.entity.Recipe;
import org.springframework.data.domain.Page;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);
    Page<Recipe> getAllRecipes(String name, Integer page);
    Recipe updateRecipe(Recipe recipe);
    String deleteRecipe(Long id);
    Recipe findById(Long id);
}
