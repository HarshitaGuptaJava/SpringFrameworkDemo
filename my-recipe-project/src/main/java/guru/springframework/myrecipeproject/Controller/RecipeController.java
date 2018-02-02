package guru.springframework.myrecipeproject.Controller;

import guru.springframework.myrecipeproject.domain.Category;
import guru.springframework.myrecipeproject.domain.UnitOfMeasure;
import guru.springframework.myrecipeproject.repositories.CategoryRepository;
import guru.springframework.myrecipeproject.repositories.UnitOfMeaseureRepository;
import guru.springframework.myrecipeproject.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class RecipeController {

   /* private CategoryRepository categoryRepository;
    private UnitOfMeaseureRepository unitOfMeasureRepository;

    public RecipeController(CategoryRepository categoryRepository, UnitOfMeaseureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/","/index",""})
    public String getIndex(){
        System.out.println("hi 123ddddd45");

        Optional<Category> categoryOptional= categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional= unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("category: " + categoryOptional.get().getId());
        System.out.println("unit Of measure: " + unitOfMeasureOptional.get().getId());
        return "index";
    }*/

   RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/","/index",""})
    public String getIndex(Model model){

        model.addAttribute("recipeList",recipeService.getRecipe());
        return "index";
    }
}
