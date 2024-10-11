package com.lets.cook.demo.service.impl;

import com.lets.cook.demo.entity.Recipe;
import com.lets.cook.demo.repository.RecipeRepository;
import com.lets.cook.demo.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RecipeServiceImpl implements RecipeService {
    RecipeRepository repository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.repository = recipeRepository;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        repository.save(recipe);
        return recipe;
    }

    @Override
    public Page<Recipe> getAllRecipes(String name, Integer page) {
        int rowsPerPage = 10;
        Pageable pageable = PageRequest.of(page-1, rowsPerPage, Sort.by("id"));
        return repository.findByNameLike(name, pageable);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        Recipe oldRecipe = repository.findById(recipe.getId()).orElse(null);
        if (oldRecipe != null) {
            repository.save(recipe);
            return recipe;
        } else {
            return null;
        }
    }

    @Override
    public String deleteRecipe(Long id) {
        Recipe deletedRecipe = repository.findById(id).orElse(null);
        if (deletedRecipe != null) {
            deletedRecipe.setDeletedAt(LocalDateTime.now());
            repository.save(deletedRecipe);
            return "Deleted recipe id " + id;
        } else {
            return "cannot find recipe id " + id;
        }
    }

    @Override
    public Recipe findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
