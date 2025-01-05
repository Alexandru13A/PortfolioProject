package ro.alexandru.PortfolioCore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Certification {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Lob
  @Column(name = "description")
  private String certificateDescription;

  @Lob
  @Column(name="certification_image")
  private byte[] certificationImage;

  


  public Certification() {
  }


  public Certification(Integer id, String name, String certificateDescription, byte[] certificationImage) {
    this.id = id;
    this.name = name;
    this.certificateDescription = certificateDescription;
    this.certificationImage = certificationImage;
  }

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

  public byte[] getImage() {
    return this.certificationImage;
  }

  public void setImage(byte[] certificationImage) {
    this.certificationImage = certificationImage;
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
