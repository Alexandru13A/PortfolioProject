package ro.alexandru.PortfolioCore.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Description {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String about;

  private String language;


  public Description(){

  }


  public Description(Integer id, String about, String language) {
    this.id = id;
    this.about = about;
    this.language = language;
  }
  


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAbout() {
    return this.about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }





  
  
  
}
