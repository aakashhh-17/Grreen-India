package com.green_india.controller;



import com.green_india.entity.FeedbackEvent;
import com.green_india.repository.FeedbackEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    private FeedbackEventRepository feedbackRepo;

    @PostMapping("/feedback")
    public ResponseEntity<?> feedback(@RequestBody Map<String, Object> payload) {
        try {
            FeedbackEvent e = new FeedbackEvent();
            if (payload.get("userId") != null) e.setUserId((Integer) payload.get("userId"));
            if (payload.get("photoId") != null) e.setPhotoId((Integer) payload.get("photoId"));
            if (payload.get("suggestionId") != null) e.setSuggestionId((Integer) payload.get("suggestionId"));
            String eventType = (String) payload.getOrDefault("eventType", "unknown");
            e.setEventType(eventType);
            e.setReward(mapEventToReward(eventType));
            if (payload.get("modelVersion") != null) e.setModelVersion((String) payload.get("modelVersion"));
            if (payload.get("sessionId") != null) e.setSessionId((String) payload.get("sessionId"));
            feedbackRepo.save(e);
            return ResponseEntity.ok(Map.of("status", "ok"));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(Map.of("status", "error", "message", ex.getMessage()));
        }
    }

    private Double mapEventToReward(String event) {
        return switch (event) {
            case "saved" -> 3.0;
            case "purchased" -> 5.0;
            case "shared" -> 2.0;
            case "clicked" -> 1.0;
            case "not_helpful" -> -1.0;
            default -> 0.0;
        };
    }
}
