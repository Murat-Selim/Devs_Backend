package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
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
	@Tool(description = "Get all technologies from the database. Returns a list of all technologies with their IDs and names.")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}
	
	@GetMapping("/{id}")
	@Tool(description = "Get a specific technology by its ID. Returns the technology details if found.")
	public GetByIdTechnologyResponse getByIdTechnology(@PathVariable @ToolParam(description = "The unique identifier of the technology to retrieve") int id) {
		return technologyService.getByIdTechnology(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	@Tool(description = "Create a new technology in the database. The name must be unique and between 2-50 characters.")
	public void add(@Valid @RequestBody CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}
	
	@PutMapping()
	@Tool(description = "Update an existing technology by ID. The name must be unique and between 2-50 characters.")
	public void update(@Valid @RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	@Tool(description = "Delete a technology by its ID.")
	public void delete(@PathVariable @ToolParam(description = "The unique identifier of the technology to delete") int id) {
		technologyService.delete(id);
	}

}
