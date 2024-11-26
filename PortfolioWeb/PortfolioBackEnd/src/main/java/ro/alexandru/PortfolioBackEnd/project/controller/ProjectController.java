package ro.alexandru.PortfolioBackEnd.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ro.alexandru.PortfolioBackEnd.image.service.ImageService;
import ro.alexandru.PortfolioBackEnd.project.service.ProjectService;
import ro.alexandru.PortfolioCore.entity.Image;
import ro.alexandru.PortfolioCore.entity.Project;

@Controller
public class ProjectController {

  private ProjectService projectService;
  private ImageService imageService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @GetMapping("/projects")
  public String getProjectsList(Model model) {

    List<Project> projects = projectService.getAllProjects();
    model.addAttribute("projects", projects);
    return "project/projects";
  }

  @GetMapping("/projects/create")
  public String createProject(Model model) {
    Project project = new Project();
    Image image = new Image();
    model.addAttribute("project", project);
    model.addAttribute("image", image);
    return "project/project_form";
  }

  @PostMapping("/projects/save")
  public String saveProject(@ModelAttribute Project project, RedirectAttributes redirectAttributes,
      @RequestParam(value = "extraImages") MultipartFile[] projectImages,
      @RequestParam(value="mainImage") MultipartFile mainImage) throws IOException {

    List<Image> images = new ArrayList<>();

    for (MultipartFile file : projectImages) {
      if (!file.isEmpty()) {

        try {
          Image image = new Image();
          image.setData(file.getBytes());
          image.setFileName(file.getOriginalFilename());
          image.setContentType(file.getContentType());
          image.setProject(project);
          images.add(image);
          imageService.saveImage(image);

        } catch (IOException e) {
          throw new RuntimeException("Eroare la citirea fișierului", e);
        }
      }
    }

    project.setImages(images);
    projectService.saveProject(project);

    return "project/projects";
  }

}
