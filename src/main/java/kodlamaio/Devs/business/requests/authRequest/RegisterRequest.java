package kodlamaio.Devs.business.requests.authRequest;

import javax.validation.constraints.NotBlank;

import kodlamaio.Devs.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    private User.Role role = User.Role.USER;
}
