package me.jeonhyeongju.springbootdevelop.controller;

import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.DTO.ArticleListViewResponse;
import me.jeonhyeongju.springbootdevelop.DTO.ArticleViewResponse;
import me.jeonhyeongju.springbootdevelop.domain.Article;
import me.jeonhyeongju.springbootdevelop.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String artcles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}
