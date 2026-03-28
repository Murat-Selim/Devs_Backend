package kodlamaio.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.TechnologyService;
import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import kodlamaio.Devs.business.responses.technologiesResponse.GetAllTechnologiesResponse;
import kodlamaio.Devs.business.responses.technologiesResponse.GetByIdTechnologyResponse;
import kodlamaio.Devs.business.rules.TechnologyBusinessRules;
import kodlamaio.Devs.core.exceptions.NotFoundException;
import kodlamaio.Devs.core.mappers.technologyMapper.TechnologyMapper;
import kodlamaio.Devs.core.mappers.technologyMapper.TechnologyRequestMapper;
import kodlamaio.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlamaio.Devs.entities.concretes.Technology;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechnologyManager implements TechnologyService {
	private final TechnologyRepository technologyRepository;
	private final TechnologyMapper technologyMapper;
	private final TechnologyRequestMapper technologyRequestMapper;
	private final TechnologyBusinessRules technologyBusinessRules;

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
        return technologyMapper.toGetAllTechnologiesResponseList(technologies);
	}

	@Override
	public GetByIdTechnologyResponse getByIdTechnology(int id) {
		Technology technology = technologyRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Technology not found with id: " + id));
		
		return technologyMapper.toGetByIdTechnologyResponse(technology);
	}
	
	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = technologyRequestMapper.toEntity(createTechnologyRequest);
		
		technologyBusinessRules.checkIfTechnologyNameIsEmpty(technology.getName());
		technologyBusinessRules.checkIfTechnologyExists(technology.getName());
		
		technologyRepository.save(technology);
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		technologyBusinessRules.checkIfTechnologyExistsById(updateTechnologyRequest.getId());
		
		Technology technology = technologyRequestMapper.toEntity(updateTechnologyRequest);
		
		technologyBusinessRules.checkIfTechnologyNameIsEmpty(technology.getName());
		technologyBusinessRules.checkIfTechnologyExistsForUpdate(technology.getName(), technology.getId());
		
		technologyRepository.save(technology);
		
	}

	@Override
	public void delete(int id) {
		this.technologyRepository.deleteById(id);
		
	}

}
