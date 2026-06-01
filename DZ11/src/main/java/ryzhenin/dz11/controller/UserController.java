package ryzhenin.dz11.controller;

import org.springframework.web.bind.annotation.*;
import ryzhenin.dz11.dto.RegisterRequest;
import ryzhenin.dz11.dto.UserResponse;
import ryzhenin.dz11.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }
}