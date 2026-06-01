package ryzhenin.dz11.service;

import org.springframework.stereotype.Service;
import ryzhenin.dz11.dto.LoginRequest;
import ryzhenin.dz11.dto.LoginResponse;
import ryzhenin.dz11.entity.UserEntity;
import ryzhenin.dz11.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public LoginResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByLogin(request.getLogin()).orElseThrow();
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return new LoginResponse(user.getId(), user.getLogin());
    }
}