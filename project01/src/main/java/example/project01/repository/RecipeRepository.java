package example.project01.repository;

import example.project01.model.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    // Define custom queries if needed

}
