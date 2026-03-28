package kodlamaio.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.ProgrammingLanguageService;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetAllProgrammingLanguagesResponse;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetByIdLanguageResponse;
import kodlamaio.Devs.business.rules.ProgrammingLanguageBusinessRules;
import kodlamaio.Devs.core.exceptions.NotFoundException;
import kodlamaio.Devs.core.mappers.programmingLanguageMapper.ProgrammingLanguageMapper;
import kodlamaio.Devs.core.mappers.programmingLanguageMapper.ProgrammingLanguageRequestMapper;
import kodlamaio.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private final ProgrammingLanguageMapper programmingLanguageMapper;
	private final ProgrammingLanguageRequestMapper programmingLanguageRequestMapper;
	private final ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository,
			ProgrammingLanguageMapper programmingLanguageMapper,
			ProgrammingLanguageRequestMapper programmingLanguageRequestMapper,
			ProgrammingLanguageBusinessRules programmingLanguageBusinessRules) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingLanguageMapper = programmingLanguageMapper;
		this.programmingLanguageRequestMapper = programmingLanguageRequestMapper;
		this.programmingLanguageBusinessRules = programmingLanguageBusinessRules;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		return programmingLanguageMapper.toGetAllProgrammingLanguagesResponseList(languages);
	}

	@Override
	public GetByIdLanguageResponse getByIdLanguage(int id) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Programming language not found with id: " + id));
		
		return programmingLanguageMapper.toGetByIdLanguageResponse(programmingLanguage);
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRequestMapper.toEntity(createProgrammingLanguageRequest);
		
		programmingLanguageBusinessRules.checkIfProgrammingLanguageNameIsEmpty(programmingLanguage.getName());
		programmingLanguageBusinessRules.checkIfProgrammingLanguageExists(programmingLanguage.getName());

		programmingLanguageRepository.save(programmingLanguage);
		
	}


	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		programmingLanguageBusinessRules.checkIfProgrammingLanguageExistsById(updateProgrammingLanguageRequest.getId());
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRequestMapper.toEntity(updateProgrammingLanguageRequest);
		
		programmingLanguageBusinessRules.checkIfProgrammingLanguageNameIsEmpty(programmingLanguage.getName());
		programmingLanguageBusinessRules.checkIfProgrammingLanguageExistsForUpdate(programmingLanguage.getName(), programmingLanguage.getId());
		
		programmingLanguageRepository.save(programmingLanguage);
		
	}

	@Override
	public void delete(int id) {
		this.programmingLanguageRepository.deleteById(id);
		
	}

}
