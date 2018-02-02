package guru.springframework.myrecipeproject.repositories;

import guru.springframework.myrecipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
