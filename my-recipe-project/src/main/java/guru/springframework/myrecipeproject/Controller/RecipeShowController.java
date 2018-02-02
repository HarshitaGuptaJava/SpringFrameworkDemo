package guru.springframework.myrecipeproject.Controller;

import guru.springframework.myrecipeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeShowController {

    RecipeService recipeService;

    public RecipeShowController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String getRecipeById(@PathVariable String id, Model model){

        model.addAttribute("recipe",recipeService.getRecipeById(new Long(id)));

        return "/recipe/show";

    }
}
