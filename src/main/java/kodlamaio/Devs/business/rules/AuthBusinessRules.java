package kodlamaio.Devs.business.rules;

import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.constants.AuthMessages;
import kodlamaio.Devs.core.exceptions.BusinessException;
import kodlamaio.Devs.dataAccess.abstracts.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthBusinessRules {
    
    private final UserRepository userRepository;
    
    public void checkIfUsernameExists(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new BusinessException(AuthMessages.USERNAME_ALREADY_EXISTS + username);
        }
    }
    
    public void checkIfUsernameNotExists(String username) {
        if (!userRepository.existsByUsername(username)) {
            throw new BusinessException(AuthMessages.USER_NOT_FOUND + username);
        }
    }
}
