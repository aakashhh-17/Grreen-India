package com.green_india.repository;



import com.green_india.entity.FeedbackEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackEventRepository extends JpaRepository<FeedbackEvent, Integer> {
}
