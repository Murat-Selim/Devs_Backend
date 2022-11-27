package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Devs.business.abstracts.TechnologyService;
import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.DeleteTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception{
		technologyService.add(createTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}

}
