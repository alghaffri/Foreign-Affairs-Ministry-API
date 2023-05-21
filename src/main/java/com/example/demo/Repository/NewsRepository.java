package com.example.demo.Repository;

import com.example.demo.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {


}
