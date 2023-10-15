package com.example.exampleproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exampleproj.model.Recipe;
import com.example.exampleproj.repository.RecipeRepository;

public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));

        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setVegetarian(updatedRecipe.isVegetarian());
        existingRecipe.setServings(updatedRecipe.getServings());
        existingRecipe.setIngredients(updatedRecipe.getIngredients());
        existingRecipe.setInstructions(updatedRecipe.getInstructions());

        return recipeRepository.save(existingRecipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> filterVegetarianRecipes() {
        return recipeRepository.findByVegetarianTrue();
    }

    public List<Recipe> filterRecipesByServings(int servings) {
        return recipeRepository.findByServings(servings);
    }

    public List<Recipe> filterRecipesByIngredients(List<String> includedIngredients, List<String> excludedIngredients) {
        if (includedIngredients != null) {
            return recipeRepository.findByIngredientsIn(includedIngredients);
        } else if (excludedIngredients != null) {
            return recipeRepository.findByIngredientsNotIn(excludedIngredients);
        } else {
            return recipeRepository.findAll();
        }
    }
}
