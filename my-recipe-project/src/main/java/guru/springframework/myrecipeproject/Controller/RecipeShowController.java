package guru.springframework.myrecipeproject.Controller;

import guru.springframework.myrecipeproject.Commands.RecipeCommand;
import guru.springframework.myrecipeproject.exceptions.NotFoundException;
import guru.springframework.myrecipeproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jt on 6/19/17.
 */
@Slf4j
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView getNotFoundPage(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView getNumberFormatExceptiontPage(Exception exception){

        log.error("Handling Number Format Exception");
        log.error(exception.getMessage());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("400error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

}