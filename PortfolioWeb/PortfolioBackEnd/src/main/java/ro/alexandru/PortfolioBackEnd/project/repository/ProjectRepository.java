package ro.alexandru.PortfolioBackEnd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.alexandru.PortfolioCore.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {



  @Query("SELECT p FROM Project p WHERE p.name LIKE %?1%")
  public Project getProjectByName(String name);

  @Query("DELETE FROM Project p WHERE p.id =?1")
  public void deleteProjectById(int id);
  
}
