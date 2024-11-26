package ro.alexandru.PortfolioCore.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "project_name")
  private String name;

  @Column(name = "project_description")
  private String description;

  @Lob
  @Column(name = "main_image")
  private byte[] mainImage;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Image> images;

  public Project() {
  }

  public Project(String name, String description) {
    this.name = name;
    this.description = description;
  }


  public Project(int id, String name, String description, byte[] mainImage, List<Image> images) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.mainImage = mainImage;
    this.images = images;
  }


  public Integer getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public List<Image> getImages() {
    return this.images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }


  public byte[] getMainImage() {
    return this.mainImage;
  }

  public void setMainImage(byte[] mainImage) {
    this.mainImage = mainImage;
  }



  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", description='" + getDescription() + "'" +
      ", mainImage='" + getMainImage() + "'" +
      ", images='" + getImages() + "'" +
      "}";
  }




}
