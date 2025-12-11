package com.green_india.repository;



import com.green_india.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {
    List<Suggestion> findByLabel(String label);
}
