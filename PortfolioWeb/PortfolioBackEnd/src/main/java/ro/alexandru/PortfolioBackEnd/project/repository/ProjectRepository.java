package ro.alexandru.PortfolioBackEnd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ro.alexandru.PortfolioCore.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {



  @Query("SELECT p FROM Project p WHERE p.name LIKE %?1%")
  public Project getUserByName(String name);

  
  
}
