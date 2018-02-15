package guru.springframework.myrecipeproject.Controller;

import guru.springframework.myrecipeproject.Commands.RecipeCommand;
import guru.springframework.myrecipeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/19/17.
 */
@Controller
public class RecipeShowController {

    private final RecipeService recipeService;

    public RecipeShowController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){//sending command to web app(Form )

        model.addAttribute("recipe",new RecipeCommand());

        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){

        RecipeCommand savedCommand=recipeService.saveRecipeCommand(command);

    return "redirect:/recipe/show/" + savedCommand.getId();
    }


    @RequestMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id,Model model){

        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";

    }

    @RequestMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id){

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";

    }
}