package me.jeonhyeongju.springbootdevelop.repository;

import me.jeonhyeongju.springbootdevelop.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// jpa 리포지토리 상속
public interface BlogRepository extends JpaRepository<Article, Long> {
}