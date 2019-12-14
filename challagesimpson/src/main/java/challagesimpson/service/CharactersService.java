package challagesimpson.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import challagesimpson.interfaces.IRepository;
import challagesimpson.interfaces.IService;
import model.Characters;
import model.Data;

@Component
public class CharactersService implements IService<Characters> {
	
	private IRepository<Characters> _charactersRepository;
	
	public CharactersService(IRepository<Characters> charactersRepository) 
	{
		this._charactersRepository = charactersRepository;
	}
	
	@Override
	public Data<Characters> findAll() {
		return _charactersRepository.findAll();
	}

	@Override
	public Characters findById(String id) {
		return _charactersRepository.findById(id);
	}

	@Override
	public ArrayList<Characters> deleteById(String id) {
		return _charactersRepository.deleteById(id);
	}

	@Override
	public Characters save(Characters p) {
		return _charactersRepository.save(p);
	}

}
