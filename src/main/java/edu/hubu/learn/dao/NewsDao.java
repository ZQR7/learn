package edu.hubu.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hubu.learn.entity.News;

public interface NewsDao extends JpaRepository<News, Long> {

}