package com.green_india.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class DetectionClient {
    private final WebClient webClient;

    public DetectionClient(@Value("${ml.service.url}") String mlUrl) {
        this.webClient = WebClient.create(mlUrl);
    }

    public Map detect(String imageUrl) {
        Map<String, String> req = Map.of("image_url", imageUrl);
        return webClient.post()
                .uri("/detect")
                .bodyValue(req)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public Map rank(Map payload) {
        return webClient.post()
                .uri("/rank")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
