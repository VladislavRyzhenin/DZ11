package ryzhenin.dz11.controller;

import org.springframework.web.bind.annotation.*;
import ryzhenin.dz11.dto.LoginRequest;
import ryzhenin.dz11.dto.LoginResponse;
import ryzhenin.dz11.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}