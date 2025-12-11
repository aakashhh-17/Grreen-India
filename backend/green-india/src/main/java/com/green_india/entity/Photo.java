package com.green_india.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String url;
    private String filename;

    private LocalDateTime uploadedAt = LocalDateTime.now();

    // getters / setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }
}
