package programmingLanguage.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import programmingLanguage.business.abstracts.ProgrammingLanguageService;
import programmingLanguage.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getlanguagebyid/{id}")
	public ProgrammingLanguage getLanguageById(@PathVariable int id) {
		return programmingLanguageService.getLanguageById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception{
		programmingLanguageService.add(programmingLanguage);
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.update(id, programmingLanguage);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		programmingLanguageService.delete(id);
	}
	
	

}
