package com.lets.cook.demo.rest;

import com.lets.cook.demo.entity.Recipe;
import com.lets.cook.demo.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/recipe")
public class RecipeRestController {
    private final RecipeService recipeService;

    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public ResponseEntity<Object> getRecipes(@RequestParam Integer page, @RequestParam String name) {
        try {
            return ResponseEntity.status(200).body(recipeService.getAllRecipes(name, page));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("create")
    public ResponseEntity<Object> createNewRecipe(@RequestBody Recipe recipe) {
        try {
            return ResponseEntity.status(200).body(recipeService.createRecipe(recipe));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("update")
    public ResponseEntity<Object> updateRecipe(@RequestBody Recipe recipe) {
        try {
            return ResponseEntity.status(200).body(recipeService.updateRecipe(recipe));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("delete")
    public ResponseEntity<Object> deleteRecipe(@RequestParam Long id) {
        try {
            return ResponseEntity.status(200).body(recipeService.deleteRecipe(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("getRecipe")
    public ResponseEntity<Object> getRecipeById(@RequestParam Long id) {
        try {
            return ResponseEntity.status(200).body(recipeService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
