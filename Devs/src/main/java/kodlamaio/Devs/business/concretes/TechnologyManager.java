package kodlamaio.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.TechnologyService;
import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.DeleteTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllTechnologiesResponse;
import kodlamaio.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlamaio.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponse = new ArrayList<GetAllTechnologiesResponse>();
        
        for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			
			technologiesResponse.add(responseItem);
		}
        
		return technologiesResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		
		if(technology.getName().isEmpty()) {
			throw new Exception("Technology cannot be empty.");
		}
		
		for (Technology technologies : technologyRepository.findAll()) {
            if (technologies.getName().equals(technology.getName())) {
                throw new Exception("Technology cannot be repeated");
            }
        }
		
		technologyRepository.save(technology);
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = new Technology();
		technology.setId(updateTechnologyRequest.getId());
		technology.setName(updateTechnologyRequest.getName());
		
		technologyRepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = new Technology();
		technology.setId(deleteTechnologyRequest.getId());
		
		Technology technologies = technologyRepository.findById(technology.getId()).get();
		technologyRepository.delete(technologies);
		
	}

}
