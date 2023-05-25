package com.example.demo.Service;

import com.example.demo.Models.News;
import com.example.demo.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired


    NewsRepository newsRepository;
    public void addPolicy(News news) {
        newsRepository.save(news);
    }

    public void updateNews(Long newsId, String title , String country ,String region ,String details) {
        Optional<News> optionalNews = newsRepository.findById(newsId);
        if (optionalNews.isPresent()) {
            News news = optionalNews.get();
            news.setTitle(title);
            news.setCountry(country);
            news.setRegion(region);
            news.setDetails(details);
            newsRepository.save(news);
        } else {
            System.out.print("NOT FOUND");
        }
    }


    public List<News> getNewsByRegion(String region) {
        return newsRepository.findByRegion(region);
    }
}
