package ro.alexandru.PortfolioBackEnd.image.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ro.alexandru.PortfolioCore.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

  @Query("SELECT i FROM Image i WHERE i.project.id =?1")
  public List<Image> getProjectImages(int projectId);

  @Modifying
  @Transactional
  @Query("DELETE FROM Image i WHERE i.project.id = ?1")
  public void deleteImagesByProjectId(int projectId);

  @Modifying
  @Transactional
  @Query("DELETE FROM Image i WHERE i.id= ?1 AND i.project.id =?2")
  public void deleteProjectImage(int imageId, int projectId);
}
