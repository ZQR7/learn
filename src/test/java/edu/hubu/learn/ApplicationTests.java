package edu.hubu.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hubu.learn.service.NewsService;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private NewsService newsService;

	@Test
	public void testNews() {
		String title = newsService.getNews(1l).getTitle();
		String content = newsService.getNews(1l).getContent();
		TestCase.assertEquals(title, "root");
		TestCase.assertEquals(content, "1234");
	}

}
