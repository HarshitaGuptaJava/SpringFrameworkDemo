package guru.springframework.myrecipeproject.service;

import guru.springframework.myrecipeproject.Commands.RecipeCommand;
import guru.springframework.myrecipeproject.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

    void deleteById(Long idToDelete);

}