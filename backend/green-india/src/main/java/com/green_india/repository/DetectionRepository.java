package com.green_india.repository;



import com.green_india.entity.Detection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectionRepository extends JpaRepository<Detection, Integer> {
}
