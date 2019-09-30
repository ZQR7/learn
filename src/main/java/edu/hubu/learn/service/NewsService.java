package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.NewsDao;
import edu.hubu.learn.entity.News;

@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public News getNews(Long id) {
        return newsDao.findById(id).get();
    }
    public List<News> getNewss() {
        return newsDao.findAll();
    }

}