package kodlamaio.Devs.business.abstracts;

import java.util.List;

import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.DeleteTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllTechnologiesResponse;

public interface TechnologyService {
	List<GetAllTechnologiesResponse> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);

}
