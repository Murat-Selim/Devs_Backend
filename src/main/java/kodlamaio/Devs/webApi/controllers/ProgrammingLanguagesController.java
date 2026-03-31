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

import kodlamaio.Devs.business.abstracts.ProgrammingLanguageService;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.programmingLanguagesRequest.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetAllProgrammingLanguagesResponse;
import kodlamaio.Devs.business.responses.programmingLanguagesResponse.GetByIdLanguageResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/programmingLanguages")
@RequiredArgsConstructor
public class ProgrammingLanguagesController {
	private final ProgrammingLanguageService programmingLanguageService;
	
	@GetMapping()
	@Tool(description = "Get all programming languages from the database. Returns a list of all programming languages with their IDs and names.")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/{id}")
	@Tool(description = "Get a specific programming language by its ID. Returns the programming language details if found.")
	public GetByIdLanguageResponse getByIdLanguage(@PathVariable @ToolParam(description = "The unique identifier of the programming language to retrieve") int id) {
		return programmingLanguageService.getByIdLanguage(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	@Tool(description = "Create a new programming language in the database. The name must be unique and between 2-50 characters.")
	public void add(@Valid @RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	@Tool(description = "Update an existing programming language by ID. The name must be unique and between 2-50 characters.")
	public void update(@Valid @RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/{id}")
	@Tool(description = "Delete a programming language by its ID. This will also delete all associated technologies.")
	public void delete(@PathVariable @ToolParam(description = "The unique identifier of the programming language to delete") int id) {
		programmingLanguageService.delete(id);
	}
	
	

}
