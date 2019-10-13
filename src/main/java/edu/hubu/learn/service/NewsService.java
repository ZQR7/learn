package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
        return newsDao.findAll(new Sort(Direction.DESC, "id"));
    }
    public News addNews(News news) {
        return newsDao.save(news);
    }

    public List<News> searchNews(String keyword) {
        News news = new News();
        news.setTitle(keyword);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("title", match->match.contains());
        Example<News> example = Example.of(news, matcher);
        Sort sort = new Sort(Direction.DESC, "id");
        return newsDao.findAll(example, sort);
    }

    public News addNews(News news) {
        return newsDao.save(news);
    }

    public void deleteNews(Long id) {
        newsDao.deleteById(id);
    }

    public void modifyNews(News news) {
        newsDao.save(news);
    }

}