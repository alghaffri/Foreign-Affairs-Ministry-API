package com.example.demo.Controller;

import com.example.demo.Models.News;
import com.example.demo.RequestObjects.RequestNews;
import com.example.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NewsController {
    @Autowired
    NewsService newsService;
    @PostMapping("/api/news")
    public ResponseEntity<Void> saveAccount (@RequestBody RequestNews requestNews) {
        createNews(requestNews);
        return ResponseEntity.ok().build();

    }
    public void createNews(RequestNews requestNews){
        News news = new News();
        news.setTitle(requestNews.getTitle());
        news.setCountry(requestNews.getCountry());
        news.setRegion(requestNews.getRegion());
        news.setDetails(requestNews.getDetails());
        news.setIsActive(true);
        news.setCreatedDate(new Date());
        newsService.addPolicy(news);
    }
    @PutMapping("/api/news/{newsId}")
    public ResponseEntity<String> updateNews(@PathVariable Long newsId, @RequestBody updateNews update) {
        try {
            String country = update.getCountry() ;
            String region =update.getRegion();
            String title=update.getTitle();
            String details=update.getDetails();
            newsService.updateNews(newsId,title,country,region,details);
            return ResponseEntity.ok("updated successfully");
        } catch (NewsNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/api/news")
    public ResponseEntity<List<News>> getNewsByCountry(@RequestParam("region") String region) {
        List<News> newsList = newsService.getNewsByRegion(region);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }





}
