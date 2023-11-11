package com.project.askdoctor.repository;


import com.project.askdoctor.entity.Article;
import com.project.askdoctor.helper.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}

