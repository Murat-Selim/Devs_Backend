package kodlamaio.Devs.business.concretes;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.AuthService;
import kodlamaio.Devs.business.requests.authRequest.LoginRequest;
import kodlamaio.Devs.business.requests.authRequest.RegisterRequest;
import kodlamaio.Devs.business.responses.authResponse.AuthResponse;
import kodlamaio.Devs.core.exceptions.BusinessException;
import kodlamaio.Devs.core.security.jwt.JwtService;
import kodlamaio.Devs.dataAccess.abstracts.UserRepository;
import kodlamaio.Devs.entities.concretes.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException("Username already exists");
        }
        
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        
        userRepository.save(user);
        
        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                )
        );
        
        return AuthResponse.builder()
                .token(token)
                .message("User registered successfully")
                .build();
    }
    
    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("User not found"));
        
        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                )
        );
        
        return AuthResponse.builder()
                .token(token)
                .message("Login successful")
                .build();
    }
}
