package me.jeonhyeongju.springbootdevelop.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.dto.AddArticleRequest;
import me.jeonhyeongju.springbootdevelop.dto.UpdateArticleRequest;
import me.jeonhyeongju.springbootdevelop.repository.BlogRepository;
import me.jeonhyeongju.springbootdevelop.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드 생성자 추가
@Service // 빈 등록
public class BlogService {
    private final BlogRepository blogRepository;

    // 생성
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 삭제
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
