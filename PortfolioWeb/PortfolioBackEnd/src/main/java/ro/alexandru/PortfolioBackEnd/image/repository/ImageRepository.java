package ro.alexandru.PortfolioBackEnd.image.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.alexandru.PortfolioCore.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
  


  @Query("SELECT i FROM Image i WHERE i.project =?1")
  public List<Image> getProjectImages(int projectId);



} 
