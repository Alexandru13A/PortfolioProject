package ro.alexandru.PortfolioBackEnd.image.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.alexandru.PortfolioBackEnd.image.repository.ImageRepository;
import ro.alexandru.PortfolioCore.entity.Image;

@Service
public class ImageService {

  private ImageRepository repository;

  public ImageService(ImageRepository repository) {
    this.repository = repository;
  }

  public void saveImage(Image image) {
    repository.save(image);
  }

  public List<Image> getProjectImages(int projectId) {
    List<Image> images = repository.getProjectImages(projectId);
    return images;
  }


  

}
