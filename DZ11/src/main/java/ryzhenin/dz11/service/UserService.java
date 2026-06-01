package ryzhenin.dz11.service;

import org.springframework.stereotype.Service;
import ryzhenin.dz11.dto.RegisterRequest;
import ryzhenin.dz11.dto.UserResponse;
import ryzhenin.dz11.entity.UserEntity;
import ryzhenin.dz11.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponse register(RegisterRequest request) {
        UserEntity user = new UserEntity(0, request.getLogin(), request.getPassword());
        UserEntity saved = userRepository.save(user);
        return new UserResponse(saved.getId(), saved.getLogin());
    }
}