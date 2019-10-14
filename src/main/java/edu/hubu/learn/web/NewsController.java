package edu.hubu.learn.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.News;
import edu.hubu.learn.service.NewsService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        newsService.deleteNews(id);
        ModelAndView mav = new ModelAndView("redirect:/news/list");
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

    @RequestMapping("/modify/{id}")
    public ModelAndView modifyNews(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("news", newsService.getNews(id));
        mav.setViewName("news_modify");
        return mav;
    }

    @RequestMapping("/do_modify")
    public ModelAndView doModifyNews(News news) {
        newsService.modifyNews(news);
        ModelAndView mav = new ModelAndView("redirect:/news/list");
        return mav;
    }

    @RequestMapping("/search")
    public ModelAndView searchNews() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("news_search");
        return mav;
    }

    @RequestMapping("/do_search")
    public ModelAndView doSearchNews(HttpServletRequest httpRequest) {
        ModelAndView mav = new ModelAndView();
        String keyword = httpRequest.getParameter("keyword");
        List<News> newss = newsService.searchNews(keyword);
        mav.addObject("newss", newss);
        mav.setViewName("newss");
        return mav;
    }



}