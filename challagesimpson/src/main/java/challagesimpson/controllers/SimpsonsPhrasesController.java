package challagesimpson.controllers;

import org.springframework.web.bind.annotation.RestController;

import model.Data;
import model.Phrases;
import service.IPharasesService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/v1/simpsonsphrases")
public class SimpsonsPhrasesController {

	@Autowired
	IPharasesService phrasesService;
	
	// Aggregate root
	@GetMapping("/phrases")
	public Data<Phrases> GetAllThePhrases() {
		return phrasesService.findAll();
	}

	// Single item
	@GetMapping("/phrases/{id}")
	public Phrases GetSinglePhrases(@PathVariable String id) {
		return phrasesService.findById(id);
	}
	
	// Create a single item
	@PostMapping("/phrases")
	Phrases newEmployee(@RequestBody Phrases newPhrases) {
	
	    return phrasesService.save(newPhrases);
	  }
	
	//Update Single Item
	 @PutMapping("/phrases/{id}")
	 public Phrases replaceEmployee(@RequestBody Phrases p, @PathVariable String id) {
		return phrasesService.save(p);
	 }
	
	 //Delete Single Item
	@DeleteMapping("/phrases/{id}")
	  ArrayList<Phrases> deleteEmployee(@PathVariable String id) {
		return phrasesService.deleteById(id);
	  }

}
