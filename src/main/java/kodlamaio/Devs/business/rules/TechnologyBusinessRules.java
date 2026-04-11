package kodlamaio.Devs.business.rules;

import kodlamaio.Devs.business.constants.TechnologyMessages;
import kodlamaio.Devs.core.exceptions.BusinessException;
import kodlamaio.Devs.core.exceptions.NotFoundException;
import kodlamaio.Devs.core.exceptions.ValidationException;
import kodlamaio.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlamaio.Devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechnologyBusinessRules {
    
    private final TechnologyRepository technologyRepository;
    
    public void checkIfTechnologyNameIsEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException(TechnologyMessages.NAME_CANNOT_BE_EMPTY);
        }
    }
    
    public void checkIfTechnologyExists(String name) {
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies) {
            if (technology.getName().equalsIgnoreCase(name)) {
                throw new BusinessException(TechnologyMessages.ALREADY_EXISTS + name);
            }
        }
    }
    
    public void checkIfTechnologyExistsForUpdate(String name, int id) {
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies) {
            if (technology.getName().equalsIgnoreCase(name) && technology.getId() != id) {
                throw new BusinessException(TechnologyMessages.ALREADY_EXISTS + name);
            }
        }
    }
    
    public void checkIfTechnologyExistsById(int id) {
        if (!technologyRepository.existsById(id)) {
            throw new NotFoundException(TechnologyMessages.NOT_FOUND + id);
        }
    }
}
