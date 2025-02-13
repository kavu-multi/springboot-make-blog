package me.jeonhyeongju.springbootdevelop.DTO;

import lombok.Getter;
import me.jeonhyeongju.springbootdevelop.domain.Article;

@Getter
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
