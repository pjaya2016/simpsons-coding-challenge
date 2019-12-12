package challagesimpson.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challagesimpson.interfaces.IService;
import model.Characters;
import model.Data;
import model.Phrases;

@RestController
@RequestMapping("/api/v1/simpsonscharacters")
public class SimpsonsCharactersController {

	@Autowired
	IService<Characters> charactersService;

	// Aggregate root
	@GetMapping("/characters")
	public Data<Characters> GetAllTheCharacters() {
		return charactersService.findAll();
	}

	// Single item
	@GetMapping("/characters/{id}")
	public Characters GetSingleCharacters(@PathVariable String id) {
		return charactersService.findById(id);
	}

	// Create a single item
	@PostMapping("/characters")
	Characters newCharacters(@RequestBody Characters newCharacters) {
		return charactersService.save(newCharacters);
	}

	// Update Single Item
	@PutMapping("/characters/{id}")
	public Characters replace(@RequestBody Characters p, @PathVariable String id) {
		return charactersService.save(p);
	}

	// Delete Single Item
	@DeleteMapping("/characters/{id}")
	ArrayList<Characters> delete(@PathVariable String id) {
		return charactersService.deleteById(id);
	}

}
