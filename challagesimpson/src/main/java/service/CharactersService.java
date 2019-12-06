package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import interfaces.IRepository;
import interfaces.IService;
import model.Characters;
import model.Data;
import model.Phrases;

public class CharactersService implements IService<Characters> {
	
	@Autowired
	private IRepository<Characters> charactersRepository;
	
	@Override
	public Data<Characters> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Characters findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Characters> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Characters save(Characters p) {
		// TODO Auto-generated method stub
		return null;
	}

}
