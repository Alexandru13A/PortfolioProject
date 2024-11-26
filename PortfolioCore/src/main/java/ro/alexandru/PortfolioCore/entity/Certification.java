package ro.alexandru.PortfolioCore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Certification {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String certificateDescription;

  // @ManyToOne
  // @JoinColumn(name = "description_id")
  // private Description description;

  @OneToOne(mappedBy = "certification", cascade = CascadeType.ALL)
  private Image image;
  


  public Certification() {
  }


  public Certification(Integer id, String name, String certificateDescription, Image image) {
    this.id = id;
    this.name = name;
    this.certificateDescription = certificateDescription;
    this.image = image;
  }



  // public Certification(Integer id, String name, String certificateDescription, Description description, Image image) {
  //   this.id = id;
  //   this.name = name;
  //   this.certificateDescription = certificateDescription;
  //   this.description = description;
  //   this.image = image;
  // }



  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCertificateDescription() {
    return this.certificateDescription;
  }

  public void setCertificateDescription(String certificateDescription) {
    this.certificateDescription = certificateDescription;
  }

  // public Description getDescription() {
  //   return this.description;
  // }

  // public void setDescription(Description description) {
  //   this.description = description;
  // }

  public Image getImage() {
    return this.image;
  }

  public void setImage(Image image) {
    this.image = image;
  }



  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", certificateDescription='" + getCertificateDescription() + "'" +
      ", images='" + getImage() + "'" +
      "}";
  }


}
