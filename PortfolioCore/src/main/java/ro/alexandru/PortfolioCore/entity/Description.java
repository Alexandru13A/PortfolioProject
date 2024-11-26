// package ro.alexandru.PortfolioCore.entity;

// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;


// public class Description {

//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Integer id;

//   private String about;

//   private String language;

//   @OneToMany(mappedBy = "description", cascade = CascadeType.ALL)
//   private List<Certification> certifications;

//   public Description(){

//   }


//   public Description(Integer id, String about, String language, List<Certification> certifications) {
//     this.id = id;
//     this.about = about;
//     this.language = language;
//     this.certifications = certifications;
//   }
  


//   public Integer getId() {
//     return this.id;
//   }

//   public void setId(Integer id) {
//     this.id = id;
//   }

//   public String getAbout() {
//     return this.about;
//   }

//   public void setAbout(String about) {
//     this.about = about;
//   }

//   public String getLanguage() {
//     return this.language;
//   }

//   public void setLanguage(String language) {
//     this.language = language;
//   }

//   public List<Certification> getCertifications() {
//     return this.certifications;
//   }

//   public void setCertifications(List<Certification> certifications) {
//     this.certifications = certifications;
//   }


//   @Override
//   public String toString() {
//     return "{" +
//       " id='" + getId() + "'" +
//       ", about='" + getAbout() + "'" +
//       ", language='" + getLanguage() + "'" +
//       ", certifications='" + getCertifications() + "'" +
//       "}";
//   }


  
  
  
// }
