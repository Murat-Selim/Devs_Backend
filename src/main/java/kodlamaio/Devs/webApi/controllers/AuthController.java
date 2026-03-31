package kodlamaio.Devs.webApi.controllers;

import jakarta.validation.Valid;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Devs.business.abstracts.AuthService;
import kodlamaio.Devs.business.requests.authRequest.LoginRequest;
import kodlamaio.Devs.business.requests.authRequest.RegisterRequest;
import kodlamaio.Devs.business.responses.authResponse.AuthResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping("/register")
    @Tool(description = "Register a new user in the system. Creates a user account with the specified username, password, and role. Returns a JWT token for authentication.")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }
    
    @PostMapping("/login")
    @Tool(description = "Login to the system with existing credentials. Returns a JWT token for authentication that can be used for subsequent API calls.")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
