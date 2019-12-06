package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import interfaces.IRepository;
import interfaces.IService;
import model.Characters;
import model.Data;

public class CharactersService implements IService<Characters> {
	
	@Autowired
	private IRepository<Characters> charactersRepository;
	
	@Override
	public Data<Characters> findAll() {
		return charactersRepository.findAll();
	}

	@Override
	public Characters findById(String id) {
		return charactersRepository.findById(id);
	}

	@Override
	public ArrayList<Characters> deleteById(String id) {
		return charactersRepository.deleteById(id);
	}

	@Override
	public Characters save(Characters p) {
		return charactersRepository.save(p);
	}

}
