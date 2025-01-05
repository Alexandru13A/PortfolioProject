package ro.alexandru.PortfolioBackEnd.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ro.alexandru.PortfolioBackEnd.image.service.ImageService;
import ro.alexandru.PortfolioBackEnd.project.service.ProjectService;
import ro.alexandru.PortfolioCore.dto.ProjectDTO;
import ro.alexandru.PortfolioCore.entity.Image;
import ro.alexandru.PortfolioCore.entity.Project;

@Controller
public class ProjectController {

  private ProjectService projectService;
  private ImageService imageService;

  public ProjectController(ProjectService projectService, ImageService imageService) {
    this.projectService = projectService;
    this.imageService = imageService;
  }

  @GetMapping("/projects")
  public String getProjectsList(Model model) {

    List<Project> projects = projectService.getAllProjects();
    model.addAttribute("projects", projects);
    return "project/projects";
  }

  @GetMapping("/projects/create")
  public String createProject(Model model) {
    ProjectDTO project = new ProjectDTO();
    model.addAttribute("project", project);
    return "project/project_form";
  }

  @PostMapping("/projects/save")
  public String saveProject(
      ProjectDTO projectDTO,
      RedirectAttributes redirectAttributes) throws IOException {

    if (projectDTO.getExtraImages().isEmpty()) {
      return "redirect:/projects/create";
    }
    projectService.saveProject(projectDTO);

    return "redirect:/projects";
  }

  @PostMapping("/projects/update")
  public String updateProject(
      @RequestParam ("id") Integer projectId,
      @RequestParam("name") String name,
      @RequestParam("description") String description,
      @RequestParam(value = "mainImage", required = false) MultipartFile mainImage,
      @RequestParam(value = "extraImages", required = false) List<MultipartFile> extraImages) throws IOException {

    projectService.updateProject(projectId, name, description, mainImage, extraImages);

    return "redirect:/projects";
  }

  @GetMapping("/projects/view/{id}")
  public String projectView(@PathVariable Integer id, Model model) {

    Project project = projectService.getProjectById(id);
    List<Image> images = imageService.getProjectImages(id);

    model.addAttribute("project", project);
    model.addAttribute("images", images);

    return "project/project_view";
  }

  @GetMapping("/projects/delete/{id}")
  public String deleteProject(@PathVariable Integer id) {

    projectService.deleteProject(id);
    imageService.deleteProjectImages(id);

    return "redirect:/projects";
  }

  @GetMapping("/projects/edit/{id}")
  public String getProjectToEdit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {

    Project project = projectService.getProjectById(id);

    if (project != null) {
      model.addAttribute("project", project);
      return "project/project_edit";
    }

    redirectAttributes.addFlashAttribute("Error at project with id: ", id);
    return "project/projects";

  }

}
