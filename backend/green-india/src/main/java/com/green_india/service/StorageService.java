package com.green_india.service;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class StorageService {
    private final Path root = Paths.get(System.getProperty("user.dir"), "uploads");

    public StorageService() throws IOException {
        Files.createDirectories(root);
    }

    public String save(MultipartFile file) {
        try {
            String orig = file.getOriginalFilename();
            String ext = "";
            if (orig != null && orig.contains(".")) {
                ext = orig.substring(orig.lastIndexOf('.'));
            }
            String name = UUID.randomUUID().toString() + ext;
            Path dest = root.resolve(name);
            file.transferTo(dest.toFile());
            return dest.toUri().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
