package ro.alexandru.PortfolioBackEnd.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.alexandru.PortfolioBackEnd.project.repository.ProjectRepository;
import ro.alexandru.PortfolioCore.entity.Project;

@Service
@Transactional
public class ProjectService {

  private ProjectRepository repository;

  public ProjectService(ProjectRepository repository) {
    this.repository = repository;
  }

  public List<Project> getAllProjects() {
    List<Project> projects = repository.findAll();
    return projects;
  }

  public Project getProjectById(Integer id) {
    return repository.findById(id).get();
  }

  public Project getProjectByName(String name) {
    return repository.getUserByName(name);
  }

  public void saveProject(Project project) {
    repository.save(project);
  }

  public void deleteProject(Integer id) {
    Project project = repository.findById(id).get();
    repository.delete(project);
  }

}
