package me.jeonhyeongju.springbootdevelop.controller;


import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.dto.CreateAccessTokenRequest;
import me.jeonhyeongju.springbootdevelop.dto.CreateAccessTokenResponse;
import me.jeonhyeongju.springbootdevelop.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken
            (@RequestBody CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefresh_token());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}
