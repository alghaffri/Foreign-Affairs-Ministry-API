package com.example.demo.Controller;

import com.example.demo.Models.News;
import com.example.demo.ResponseObjects.ResourceNotFoundException;
import com.example.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> news = newsService.getAllNews();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("News not found with id: " + id));
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        News updatedNews = newsService.updateNews(news);
        return new ResponseEntity<>(updatedNews, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/country/{country}")
    public ResponseEntity<List<News>> getNewsByCountry(@PathVariable String country) {
        List<News> news = newsService.getNewsByCountry(country);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<News>> getNewsByRegion(@PathVariable String region) {
        List<News> news = newsService.getNewsByRegion(region);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<News>> getNewsByTitle(@PathVariable String title) {
        List<News> news = newsService.getNewsByTitle(title);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }



    
}
