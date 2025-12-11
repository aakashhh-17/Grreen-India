package com.green_india.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "detections")
public class Detection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    private String label;
    private Double confidence;

    @Column(columnDefinition = "json")
    private String bbox;

    // getters / setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Photo getPhoto() { return photo; }
    public void setPhoto(Photo photo) { this.photo = photo; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public Double getConfidence() { return confidence; }
    public void setConfidence(Double confidence) { this.confidence = confidence; }
    public String getBbox() { return bbox; }
    public void setBbox(String bbox) { this.bbox = bbox; }
}
