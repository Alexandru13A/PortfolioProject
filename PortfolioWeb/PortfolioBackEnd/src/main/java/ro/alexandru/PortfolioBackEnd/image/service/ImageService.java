package ro.alexandru.PortfolioBackEnd.image.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ro.alexandru.PortfolioBackEnd.image.repository.ImageRepository;
import ro.alexandru.PortfolioCore.entity.Image;

@Service
@Transactional
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

  public Image getImage(int id) {
    return repository.findById(id).get();
  }

  public void deleteProjectImages(int projectId) {
    repository.deleteImagesByProjectId(projectId);
  }

  public void deleteImageFromProject(int imageId,int projectId){
    Optional<Image> image = repository.findById(imageId);

    if (image.isPresent() && image.get().getProject().getId() == projectId) {
        repository.deleteById(imageId);
    } else {
        throw new IllegalArgumentException("Image not found or does not belong to the project.");
    }
  }

}
