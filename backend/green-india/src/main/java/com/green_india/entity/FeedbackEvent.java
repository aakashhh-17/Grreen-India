package com.green_india.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_events")
public class FeedbackEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer photoId;
    private Integer suggestionId;
    private String eventType;
    private Double reward;
    private String modelVersion;
    private String sessionId;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters / setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public Integer getPhotoId() { return photoId; }
    public void setPhotoId(Integer photoId) { this.photoId = photoId; }
    public Integer getSuggestionId() { return suggestionId; }
    public void setSuggestionId(Integer suggestionId) { this.suggestionId = suggestionId; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public Double getReward() { return reward; }
    public void setReward(Double reward) { this.reward = reward; }
    public String getModelVersion() { return modelVersion; }
    public void setModelVersion(String modelVersion) { this.modelVersion = modelVersion; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
