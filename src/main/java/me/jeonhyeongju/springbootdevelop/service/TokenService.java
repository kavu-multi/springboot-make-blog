package me.jeonhyeongju.springbootdevelop.service;

import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.config.jwt.TokenProvider;
import me.jeonhyeongju.springbootdevelop.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        //토큰 유효성 검사, 실패시 예외처리
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
