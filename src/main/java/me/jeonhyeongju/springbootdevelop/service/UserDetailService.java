package me.jeonhyeongju.springbootdevelop.service;

import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.Repository.UserRepository;
import me.jeonhyeongju.springbootdevelop.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}