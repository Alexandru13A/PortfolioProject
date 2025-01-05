package ro.alexandru.PortfolioCore.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  private byte[] data;

  private String fileName;

  @OneToOne
  @JoinColumn(name = "certification")
  private Certification certification;

  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;

  public Image() {
  }

  public Image(int id, byte[] data) {
    this.id = id;
    this.data = data;
  }

  public Image(int id, byte[] data, String fileName,Certification certification) {
    this.id = id;
    this.data = data;
    this.fileName = fileName;
    this.certification = certification;
  }

  public Image(int id, byte[] data,String fileName,Project project) {
    this.id = id;
    this.data = data;
    this.fileName = fileName;
    this.project = project;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public byte[] getData() {
    return this.data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public Project getProject() {
    return this.project;
  }

  public void setProject(Project project) {
    this.project = project;
  }


  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Certification getCertification() {
    return this.certification;
  }

  public void setCertification(Certification certification) {
    this.certification = certification;
  }


}
