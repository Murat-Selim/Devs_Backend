package kodlamaio.Devs.business.abstracts;

import java.util.List;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getLanguageById(int id);
	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void update(int id, ProgrammingLanguage programmingLanguage);
	void delete(int id);

}
