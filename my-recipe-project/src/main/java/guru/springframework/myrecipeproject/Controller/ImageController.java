package guru.springframework.myrecipeproject.Controller;

import guru.springframework.myrecipeproject.Commands.RecipeCommand;
import guru.springframework.myrecipeproject.service.ImageService;
import guru.springframework.myrecipeproject.service.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    ImageService imageService;
    RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeId}/image")
    public String getImageForm(@PathVariable String recipeId, Model model) {


        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "/recipe/ImageUploadForm";
    }

    @PostMapping("/recipe/{recipeId}/image")
    public String handleImagePost(@PathVariable String recipeId, @RequestParam("imagefile") MultipartFile file)
    {
        imageService.saveImageFile(Long.valueOf(recipeId),file);

        return "redirect:/recipe" +"/show/"+ recipeId ;
    }

    @GetMapping("recipe/{recipeId}/recipeimage")
    public void renderImageFromDB (@PathVariable String recipeId, HttpServletResponse response)throws IOException {

        RecipeCommand command= recipeService.findCommandById(Long.valueOf(recipeId));
        if (command.getImage() != null) {
            byte[] byteArray = new byte[command.getImage().length];

            int i = 0;
            for (Byte b : command.getImage()) {
                byteArray[i++] = b;
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }

    }
}
