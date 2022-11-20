package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Devs.business.abstracts.ProgrammingLanguageService;
import kodlamaio.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlamaio.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlamaio.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getlanguagebyid/{id}")
	public ProgrammingLanguage getLanguageById(@RequestParam int id) {
		return programmingLanguageService.getLanguageById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}
	
	

}
