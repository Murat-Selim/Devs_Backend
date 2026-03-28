package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Devs.business.abstracts.TechnologyService;
import kodlamaio.Devs.business.requests.technologiesRequest.CreateTechnologyRequest;
import kodlamaio.Devs.business.requests.technologiesRequest.UpdateTechnologyRequest;
import kodlamaio.Devs.business.responses.technologiesResponse.GetAllTechnologiesResponse;
import kodlamaio.Devs.business.responses.technologiesResponse.GetByIdTechnologyResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologiesController {
	private final TechnologyService technologyService;
	
	@GetMapping()
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdTechnologyResponse getByIdTechnology(@PathVariable int id) {
		return technologyService.getByIdTechnology(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid @RequestBody CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}
	
	@PutMapping()
	public void update(@Valid @RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		technologyService.delete(id);
	}

}
