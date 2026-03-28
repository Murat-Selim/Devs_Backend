package kodlamaio.Devs.business.abstracts;

import kodlamaio.Devs.business.requests.authRequest.LoginRequest;
import kodlamaio.Devs.business.requests.authRequest.RegisterRequest;
import kodlamaio.Devs.business.responses.authResponse.AuthResponse;

public interface AuthService {
    
    AuthResponse register(RegisterRequest request);
    
    AuthResponse login(LoginRequest request);
}
