package ro.alexandru.PortfolioBackEnd.image.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ro.alexandru.PortfolioBackEnd.image.service.ImageService;
import ro.alexandru.PortfolioBackEnd.project.service.ProjectService;
import ro.alexandru.PortfolioCore.entity.Image;
import ro.alexandru.PortfolioCore.entity.Project;

@RestController
@RequestMapping("/images")
public class ImageRestController {

  private ImageService imageService;
  private ProjectService projectService;

  public ImageRestController(ImageService imageService, ProjectService projectService) {
    this.imageService = imageService;
    this.projectService = projectService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<byte[]> getImage(@PathVariable int id) {
    Optional<Image> imageOptional = Optional.of(imageService.getImage(id));

    if (imageOptional.isPresent()) {
      Image image = imageOptional.get();
      return ResponseEntity.ok()
          .header("Content-Type", "image/jpeg") // sau alt tip MIME
          .body(image.getData());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{projectId}/remove/{imageId}")
  @ResponseBody
  public ResponseEntity<Void> deleteProjectImage(@PathVariable(name = "projectId") int projectId, @PathVariable(name = "imageId") int imageId) {
      System.out.println("Deleting image with ID: " + imageId + " from project: " + projectId);
      imageService.deleteImageFromProject(imageId, projectId);
      return ResponseEntity.ok().build();
  }

@PostMapping("/{projectId}/add")
@ResponseBody
public ResponseEntity<List<Image>> addProjectImages(
    @PathVariable int projectId,
    @RequestParam("files") List<MultipartFile> files) throws IOException {

    List<Image> images = new ArrayList<>();
    Project project = projectService.getProjectById(projectId);

    for (MultipartFile file : files) {
        Image image = new Image();
        image.setData(file.getBytes());
        image.setFileName(file.getOriginalFilename());
        image.setProject(project);
        imageService.saveImage(image);
        images.add(image);
    }

    return ResponseEntity.ok(images);
}

}
