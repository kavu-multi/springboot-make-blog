package me.jeonhyeongju.springbootdevelop.service;

import lombok.RequiredArgsConstructor;
import me.jeonhyeongju.springbootdevelop.dto.AddUserRequest;
import me.jeonhyeongju.springbootdevelop.repository.UserRepository;
import me.jeonhyeongju.springbootdevelop.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                //패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("Unexpected user"));
    }
}
