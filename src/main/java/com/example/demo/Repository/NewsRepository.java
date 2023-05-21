package com.example.demo.Repository;

import com.example.demo.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByCountry(String country);
    List<News> findByRegion(String region);
    List<News> findByTitleContaining(String title);

}
