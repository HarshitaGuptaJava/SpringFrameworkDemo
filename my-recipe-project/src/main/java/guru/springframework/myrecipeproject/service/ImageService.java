package guru.springframework.myrecipeproject.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

public  void saveImageFile(Long id, MultipartFile file);
}
