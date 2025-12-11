package com.green_india.repository;



import com.green_india.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
