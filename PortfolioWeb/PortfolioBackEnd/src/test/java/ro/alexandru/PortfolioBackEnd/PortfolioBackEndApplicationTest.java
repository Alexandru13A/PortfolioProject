package ro.alexandru.PortfolioBackEnd;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ro.alexandru.PortfolioBackEnd.image.repository.ImageRepository;
import ro.alexandru.PortfolioBackEnd.project.repository.ProjectRepository;
import ro.alexandru.PortfolioCore.entity.Image;
import ro.alexandru.PortfolioCore.entity.Project;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PortfolioBackEndApplicationTest {

  @Autowired
  private ProjectRepository projectRepository;
  @Autowired
  private ImageRepository imageRepository;


  @Test
  public void createProject(){

    byte[] data = {5,'b',5,6,7,8,'f'};

    Project project = new Project();
    project.setName("Spring boot shop project");
    project.setDescription("It s a E-commerce project created with: \n -Spring boot \n -Java \n -HTML \n -CSS");

    Image image = new Image();
    image.setData(data);
    image.setProject(project);
    
    
    Project savedProject = projectRepository.save(project);
    Image savedImage = imageRepository.save(image);

    System.out.println(project);
    System.out.println(image);

    assertThat(savedProject).isNotNull();
    assertThat(savedProject.getId()).isGreaterThan(0);

    assertThat(savedImage).isNotNull();
    assertThat(savedImage.getId()).isGreaterThan(0);

  }
  
}
