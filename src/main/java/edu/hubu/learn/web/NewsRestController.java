package edu.hubu.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hubu.learn.entity.Result;
import edu.hubu.learn.entity.News;
import edu.hubu.learn.service.NewsService;

@RestController

@RequestMapping("/rest/news")
public class NewsRestController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getById(@PathVariable("id") long id) {
        return newsService.getNews(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAll() {
        return newsService.getNewss();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object addNews(News news) {
        newsService.addNews(news);
        return news;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object modifyNews(News news) {
        newsService.modifyNews(news);
        return news;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteNews(@PathVariable("id") long id) {
        try {
            newsService.deleteNews(id);
        } catch (Exception e) {
            return new Result(false, e);
        }
        return new Result(true, null);
    }

    @RequestMapping(value = "/search/{key}", method = RequestMethod.GET)
    public Object searchNews(String key) {
        return newsService.searchNews(key);
    }
}