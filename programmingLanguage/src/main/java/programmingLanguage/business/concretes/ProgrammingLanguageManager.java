package programmingLanguage.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programmingLanguage.business.abstracts.ProgrammingLanguageService;
import programmingLanguage.dataAccess.abstracts.ProgrammingLanguageRepository;
import programmingLanguage.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getLanguageById(int id) {
		return programmingLanguageRepository.getLanguageById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception{
		if (programmingLanguage.getName().isEmpty()) {
            throw new Exception("Programming language cannot be empty.");
        }
		
        for (ProgrammingLanguage language : programmingLanguageRepository.getAll()) {
            if (language.getName().equals(programmingLanguage.getName())) {
                throw new Exception("Programming language cannot be repeated");
            }
        }

        programmingLanguageRepository.add(programmingLanguage);
		
	}

	@Override
	public void update(int id, ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.update(id, programmingLanguage);
		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
		
	}

}