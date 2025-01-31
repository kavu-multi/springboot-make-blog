package me.jeonhyeongju.springbootdevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //created, updated 자동업데이트
@SpringBootApplication
public class SpringBootDevelopApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootDevelopApplication.class, args);
    }
}
