package com.example.exampleproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exampleproj.model.Recipe;
import com.example.exampleproj.service.RecipeService;

@RestController
@RequestMapping("/recipes")

public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return recipeService.filterVegetarianRecipes();
    }

    @GetMapping("/servings/{servings}")
    public List<Recipe> getRecipesByServings(@PathVariable int servings) {
        return recipeService.filterRecipesByServings(servings);
    }

    @GetMapping("/ingredients")
    public List<Recipe> getRecipesByIngredients(
            @RequestParam(value = "include", required = false) List<String> includedIngredients,
            @RequestParam(value = "exclude", required = false) List<String> excludedIngredients) {
        return recipeService.filterRecipesByIngredients(includedIngredients, excludedIngredients);
    }

}
