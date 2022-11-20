package kodlamaio.Devs.dataAccess.abstracts;

import java.util.List;

import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getLanguageById(int id);
	void add(ProgrammingLanguage programmingLanguage);
	void update(int id, ProgrammingLanguage programmingLanguage);
	void delete(int id);

}
