package guru.springframework.myrecipeproject.service;

import guru.springframework.myrecipeproject.domain.Recipe;
import guru.springframework.myrecipeproject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipe() {

        Set<Recipe> recipes=new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe getRecipeById(Long id) {

        Optional<Recipe> recipeOptional=recipeRepository.findById(id);
        if(!recipeOptional.isPresent()){

throw new RuntimeException("Recipe Not found");
        }
        return recipeOptional.get();
    }
}
