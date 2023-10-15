package com.example.exampleproj.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exampleproj.model.Recipe;
import com.example.exampleproj.repository.RecipeRepository;

import jakarta.annotation.PostConstruct;

@Service
public class SampleDataService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public SampleDataService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void initializeSampleData() {
        Recipe recipe1 = new Recipe("Vegetable Stir-Fry", true, 4, Arrays.asList("carrots", "broccoli", "peppers"),
                "Stir-fry veggies in a wok.");
        Recipe recipe2 = new Recipe("Pasta Carbonara", false, 2, Arrays.asList("pasta", "eggs", "bacon"),
                "Cook pasta, mix with eggs and bacon.");

        recipeRepository.saveAll(Arrays.asList(recipe1, recipe2));
    }
}
