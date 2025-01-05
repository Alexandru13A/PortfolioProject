package ro.alexandru.PortfolioBackEnd.project.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.alexandru.PortfolioBackEnd.project.service.ProjectService;
import ro.alexandru.PortfolioCore.entity.Project;

@RestController
@RequestMapping("/project/image")
public class ProjectRestController {

  private ProjectService projectService;

  public ProjectRestController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<byte[]> getMainImage(@PathVariable Integer id) {

    Optional<Project> projectImage = projectService.getProjectImage(id);

    if (projectImage.isPresent()) {
      Project project = projectImage.get();
      return ResponseEntity.ok()
          .header("Content-Type", "image/jpeg")
          .body(project.getMainImage());
    }

    return ResponseEntity.notFound().build();
  }

}
