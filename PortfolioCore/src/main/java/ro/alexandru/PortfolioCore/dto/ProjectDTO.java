package ro.alexandru.PortfolioCore.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProjectDTO {

  private String name;
  private String description;
  private MultipartFile mainImage;
  private List<MultipartFile> extraImages;
  
}
