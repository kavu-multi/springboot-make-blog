package me.jeonhyeongju.springbootdevelop.Repository;

import me.jeonhyeongju.springbootdevelop.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
