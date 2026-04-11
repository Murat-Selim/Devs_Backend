package kodlamaio.Devs.business.rules;

import kodlamaio.Devs.business.constants.ProgrammingLanguageMessages;
import kodlamaio.Devs.core.exceptions.BusinessException;
import kodlamaio.Devs.core.exceptions.NotFoundException;
import kodlamaio.Devs.core.exceptions.ValidationException;
import kodlamaio.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageBusinessRules {
    
    private final ProgrammingLanguageRepository programmingLanguageRepository;
    
    public void checkIfProgrammingLanguageNameIsEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException(ProgrammingLanguageMessages.NAME_CANNOT_BE_EMPTY);
        }
    }
    
    public void checkIfProgrammingLanguageExists(String name) {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        for (ProgrammingLanguage language : languages) {
            if (language.getName().equalsIgnoreCase(name)) {
                throw new BusinessException(ProgrammingLanguageMessages.ALREADY_EXISTS + name);
            }
        }
    }
    
    public void checkIfProgrammingLanguageExistsForUpdate(String name, int id) {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        for (ProgrammingLanguage language : languages) {
            if (language.getName().equalsIgnoreCase(name) && language.getId() != id) {
                throw new BusinessException(ProgrammingLanguageMessages.ALREADY_EXISTS + name);
            }
        }
    }
    
    public void checkIfProgrammingLanguageExistsById(int id) {
        if (!programmingLanguageRepository.existsById(id)) {
            throw new NotFoundException(ProgrammingLanguageMessages.NOT_FOUND + id);
        }
    }
}
