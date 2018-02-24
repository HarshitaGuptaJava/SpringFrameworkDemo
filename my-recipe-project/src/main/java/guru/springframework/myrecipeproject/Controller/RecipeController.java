package guru.springframework.myrecipeproject.Controller;




import guru.springframework.myrecipeproject.exceptions.NotFoundException;
import guru.springframework.myrecipeproject.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
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


    /**
     * Created by jt on 6/1/17.
     */


        private final RecipeService recipeService;

        public RecipeController(RecipeService recipeService) {
            this.recipeService = recipeService;
        }

        @RequestMapping({"", "/", "/index"})
        public String getIndexPage(Model model) {
            log.debug("Getting Index page");
            System.out.println("I am in controller");
            System.out.println("recipe present" + model.containsAttribute("recipes"));

            model.addAttribute("recipes", recipeService.getRecipes());
            System.out.println("recipe present" + model.containsAttribute("recipes"));

            return "index";
        }




}
