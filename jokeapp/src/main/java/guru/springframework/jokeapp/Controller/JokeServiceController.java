package guru.springframework.jokeapp.Controller;

import guru.springframework.jokeapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeServiceController {


    private JokeService jokeService;

    public JokeServiceController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model){
       model.addAttribute("joke", jokeService.getJoke());
        return "chucknorris";
    }
}
