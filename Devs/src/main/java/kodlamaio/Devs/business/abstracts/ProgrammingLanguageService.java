package kodlamaio.Devs.business.abstracts;

import java.util.List;

import kodlamaio.Devs.business.requests.programmingLanguagesRequest.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.DeleteProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	ProgrammingLanguage getLanguageById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);

}
