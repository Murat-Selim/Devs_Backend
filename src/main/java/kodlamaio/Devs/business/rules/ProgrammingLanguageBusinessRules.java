package kodlamaio.Devs.business.rules;

import kodlamaio.Devs.core.exceptions.BusinessException;
import kodlamaio.Devs.core.exceptions.NotFoundException;
import kodlamaio.Devs.core.exceptions.ValidationException;
import kodlamaio.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageBusinessRules {
    
    private ProgrammingLanguageRepository programmingLanguageRepository;
    
    @Autowired
    public ProgrammingLanguageBusinessRules(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }
    
    public void checkIfProgrammingLanguageNameIsEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Programming language name cannot be empty.");
        }
    }
    
    public void checkIfProgrammingLanguageExists(String name) {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        for (ProgrammingLanguage language : languages) {
            if (language.getName().equalsIgnoreCase(name)) {
                throw new BusinessException("Programming language already exists: " + name);
            }
        }
    }
    
    public void checkIfProgrammingLanguageExistsForUpdate(String name, int id) {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        for (ProgrammingLanguage language : languages) {
            if (language.getName().equalsIgnoreCase(name) && language.getId() != id) {
                throw new BusinessException("Programming language already exists: " + name);
            }
        }
    }
    
    public void checkIfProgrammingLanguageExistsById(int id) {
        if (!programmingLanguageRepository.existsById(id)) {
            throw new NotFoundException("Programming language not found with id: " + id);
        }
    }
}
