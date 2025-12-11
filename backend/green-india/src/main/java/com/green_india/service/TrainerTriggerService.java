package com.green_india.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TrainerTriggerService {
    private final WebClient webClient;

    public TrainerTriggerService(@Value("${ml.service.url}") String mlUrl) {
        this.webClient = WebClient.create(mlUrl);
    }

    // runs daily at 2:00 AM server time; adjust as needed
    @Scheduled(cron = "0 0 2 * * *")
    public void triggerTrainer() {
        try {
            webClient.post().uri("/train").retrieve().bodyToMono(String.class).block();
            System.out.println("Triggered ML trainer.");
        } catch (Exception ex) {
            System.err.println("Failed to trigger trainer: " + ex.getMessage());
        }
    }
}
