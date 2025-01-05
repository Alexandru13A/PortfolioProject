package ro.alexandru.PortfolioBackEnd.project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ro.alexandru.PortfolioBackEnd.image.service.ImageService;
import ro.alexandru.PortfolioBackEnd.project.repository.ProjectRepository;
import ro.alexandru.PortfolioCore.dto.ProjectDTO;
import ro.alexandru.PortfolioCore.entity.Image;
import ro.alexandru.PortfolioCore.entity.Project;

@Service
@Transactional
public class ProjectService {

  private ProjectRepository repository;
  private ImageService imageService;

  public ProjectService(ProjectRepository repository, ImageService imageService) {
    this.repository = repository;
    this.imageService = imageService;
  }

  public List<Project> getAllProjects() {
    List<Project> projects = repository.findAll();
    return projects;
  }

  public Optional<Project> getProjectImage(int id) {
    Optional<Project> project = repository.findById(id);
    return project;
  }

  public Project getProjectById(int id) {
    return repository.findById(id).get();
  }

  public Project getProjectByName(String name) {
    return repository.getProjectByName(name);
  }

  public void saveProject(ProjectDTO projectDTO) throws IOException {

    Project project = new Project();
    project.setName(projectDTO.getName());
    project.setDescription(projectDTO.getDescription());
    project.setMainImage(projectDTO.getMainImage().getBytes());
    project.setExtraImages(getExtraImages(projectDTO.getExtraImages(), project));

    repository.save(project);

  }

  public void deleteProject(Integer id) {
    Project project = repository.findById(id).get();
    repository.delete(project);
  }

  private List<Image> getExtraImages(List<MultipartFile> extraImages, Project project) throws IOException {

    List<Image> images = new ArrayList<>();
    for (MultipartFile file : extraImages) {
      Image image = new Image();
      image.setData(file.getBytes());
      image.setFileName(file.getOriginalFilename());
      image.setProject(project);
      imageService.saveImage(image);
      images.add(image);
    }
    return images;

  }

  public Project updateProject(Integer projectId, String name, String description, MultipartFile mainImage,
      List<MultipartFile> extraImages) throws IOException {

    Project project = repository.findById(projectId)
        .orElseThrow(() -> new RuntimeException("Project not found"));

    // Actualizează câmpurile proiectului
    project.setName(name);
    project.setDescription(description);

    if (mainImage != null && !mainImage.isEmpty()) {
      project.setMainImage(mainImage.getBytes());
    }

    // Adaugă imagini suplimentare dacă sunt furnizate
    if (extraImages != null && !extraImages.isEmpty()) {
      for (MultipartFile file : extraImages) {
          if (!file.isEmpty()) {
              Image extraImage = new Image();
              extraImage.setData(file.getBytes());
              extraImage.setFileName(file.getOriginalFilename());
              extraImage.setProject(project);
              imageService.saveImage(extraImage);
          }
      }
  }

    // Salvează proiectul actualizat
    return repository.save(project);
  }
}
