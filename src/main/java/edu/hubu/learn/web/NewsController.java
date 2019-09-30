package edu.hubu.learn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.News;
import edu.hubu.learn.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {



    @Autowired
    private NewsService newsService;

    @RequestMapping("/{id}")
    public ModelAndView news(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        News news = newsService.getNews(id);
        mav.addObject("news", news);
        mav.setViewName("news");
        return mav;
    }
    @RequestMapping("/list")
    public ModelAndView newss() {
        ModelAndView mav = new ModelAndView();
        List<News> newss = newsService.getNewss();
        mav.addObject("newss", newss);
        mav.setViewName("newss");
        return mav;
    }
    
    @RequestMapping("/add")
    public ModelAndView addNews() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("news_add");
        return mav;
    }

    @RequestMapping("/do_add")
    public ModelAndView doAddNews(News news) {
        newsService.addNews(news);
        ModelAndView mav = new ModelAndView("redirect:/news/list");
        return mav;
    }
}