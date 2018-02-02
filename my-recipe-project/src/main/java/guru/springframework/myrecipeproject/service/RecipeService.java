package guru.springframework.myrecipeproject.service;

import guru.springframework.myrecipeproject.domain.Recipe;
import guru.springframework.myrecipeproject.repositories.RecipeRepository;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipe();

    Recipe getRecipeById(Long id);
}
