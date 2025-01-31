package me.jeonhyeongju.springbootdevelop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class) //엔티티 생성시간과 수정시간 자동으로 기록하기 위함
@Entity //엔티티로 설정
@Getter //Get관련 메서드 사용가능
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 protected
public class Article {
    @Id //Id필드 기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 1++
    @Column(name = "id", updatable = false) //열 속성 이름 Id, 업데이트 불가
    private Long id;

    @Column(name = "title", nullable = false) //열 속성 이름 title, 빈 상태로 사용 불가
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 객체를 생성
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    @CreatedDate //엔티티 생성 시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate //엔티티 수정시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
