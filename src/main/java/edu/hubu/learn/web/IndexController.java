package edu.hubu.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.News;
import edu.hubu.learn.service.NewsService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/news")
    public ModelAndView news() {
        ModelAndView mav = new ModelAndView();
        News news = newsService.getNews(1l);
        mav.addObject("news", news);
        mav.setViewName("news");
        return mav;
    }


}