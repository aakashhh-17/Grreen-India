package com.green_india.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "suggestions")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;
    private String title;
    private String type; // product|diy|recycle|vendor

    @Column(columnDefinition = "text")
    private String content;

    private Double impactScore;

    @Column(columnDefinition = "json")
    private String extra;

    // getters / setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Double getImpactScore() { return impactScore; }
    public void setImpactScore(Double impactScore) { this.impactScore = impactScore; }
    public String getExtra() { return extra; }
    public void setExtra(String extra) { this.extra = extra; }
}
