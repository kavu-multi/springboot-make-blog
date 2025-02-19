package me.jeonhyeongju.springbootdevelop.service;

import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.domain.RefreshToken;
import me.jeonhyeongju.springbootdevelop.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexcepted token"));
    }
}
