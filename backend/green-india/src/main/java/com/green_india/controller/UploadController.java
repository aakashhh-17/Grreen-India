package com.green_india.controller;



import com.green_india.entity.Photo;
import com.green_india.entity.Suggestion;
import com.green_india.repository.PhotoRepository;
import com.green_india.repository.SuggestionRepository;
import com.green_india.service.StorageService;
import com.green_india.service.DetectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private DetectionClient detectionClient;

    @Autowired
    private SuggestionRepository suggestionRepo;

    @Autowired
    private PhotoRepository photoRepo;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,
                                    @RequestParam(value = "userId", required = false) Integer userId) {
        String url = storageService.save(file);

        Photo photo = new Photo();
        photo.setUrl(url);
        photo.setFilename(file.getOriginalFilename());
        photoRepo.save(photo);

        Map detectionResp = detectionClient.detect(url);
        Object detections = detectionResp.get("detections");

        String label = "unknown";
        if (detections instanceof java.util.List && !((java.util.List)detections).isEmpty()) {
            Map first = (Map)((java.util.List)detections).get(0);
            label = (String) first.getOrDefault("label", "unknown");
        }

        List<Suggestion> suggestions = suggestionRepo.findByLabel(label);
        return ResponseEntity.ok(Map.of(
                "photoId", photo.getId(),
                "detections", detections,
                "suggestions", suggestions
        ));
    }
}
