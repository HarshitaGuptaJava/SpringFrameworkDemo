package guru.springframework.myrecipeproject.service;

import guru.springframework.myrecipeproject.domain.Recipe;
import guru.springframework.myrecipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{
    RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
        public void saveImageFile(Long recipeId, MultipartFile file) {

        try {


    Optional<Recipe> recipeRepositoryOptional = recipeRepository.findById(recipeId);
    Recipe recipe=recipeRepositoryOptional.get();
    Byte[] byteObject = new Byte[file.getBytes().length];
    int i=0;
            for (Byte b:file.getBytes()) {

                byteObject[i++]=b;
                
            }
            recipe.setImage(byteObject);
            recipeRepository.save(recipe);

    log.debug("Received a file");
    }
    catch (IOException e){

    log.error("Error Occured"+e);
    e.printStackTrace();
}


        }
}
