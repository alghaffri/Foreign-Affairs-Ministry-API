package com.example.demo.Controller;

import com.example.demo.Models.News;
import com.example.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
    @PostMapping
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News newNews = newsService.addNews(news);
        return new ResponseEntity<>(newNews, HttpStatus.CREATED);
    }

}
