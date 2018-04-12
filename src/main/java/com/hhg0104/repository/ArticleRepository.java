package com.hhg0104.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hhg0104.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
