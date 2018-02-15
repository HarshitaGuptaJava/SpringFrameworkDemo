package guru.springframework.myrecipeproject.Controller;

import guru.springframework.myrecipeproject.Commands.IngredientCommand;
import guru.springframework.myrecipeproject.Commands.RecipeCommand;
import guru.springframework.myrecipeproject.Commands.UnitOfMeasureCommand;
import guru.springframework.myrecipeproject.service.IngredientService;
import guru.springframework.myrecipeproject.service.RecipeService;
import guru.springframework.myrecipeproject.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    RecipeService recipeService;
    IngredientService ingredientService;
    UnitOfMeasureService unitOfMeasureService;


    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
    model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
    return "/recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model)
    {
        model.addAttribute("ingredient",ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId),Long.valueOf(ingredientId)));

        return "recipe/ingredient/show";
    }



    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/new")
    public String newRecipe(@PathVariable String recipeId, Model model){

        //make sure we have a good id value
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        //todo raise exception if null

        //need to return back parent id for hidden form property
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);

        //init uom
        ingredientCommand.setUom(new UnitOfMeasureCommand());

        model.addAttribute("uomList",  unitOfMeasureService.listAllUom());

        return "recipe/Ingredient/form";
    }


    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{Id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String Id,Model model){

        model.addAttribute("ingredient",ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId),Long.valueOf(Id)));
        model.addAttribute("uomList",unitOfMeasureService.listAllUom());
        return "recipe/Ingredient/form";
    }

    @PostMapping
    @RequestMapping("/recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand ingredientCommand){

        IngredientCommand savedCommand= ingredientService.saveIngredientCommand(ingredientCommand);


        return "redirect:/recipe/" + savedCommand.getRecipeId()+ "/ingredient/" +savedCommand.getId() +"/show";

    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{Id}/delete")
    public String deleteIngredient(@PathVariable String recipeId,@PathVariable String Id) {

        ingredientService.deleteById(Long.valueOf(recipeId),Long.valueOf(Id));
        return "redirect:/recipe/"+recipeId+"/ingredients";

    }

}
