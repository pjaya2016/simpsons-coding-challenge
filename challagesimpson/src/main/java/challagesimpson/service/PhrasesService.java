package challagesimpson.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challagesimpson.interfaces.IRepository;
import challagesimpson.interfaces.IService;
import model.Data;
import model.Phrases;

@Service
public class PhrasesService implements IService<Phrases> {
	@Autowired
	private IRepository<Phrases> phrasesRepository;

	@Override
	public Data<Phrases> findAll() {
		return phrasesRepository.findAll();
	}

	@Override
	public Phrases findById(String id) {
		return phrasesRepository.findById(id);
	}

	@Override
	public ArrayList<Phrases> deleteById(String id) {
		return phrasesRepository.deleteById(id);
	}

	@Override
	public Phrases save(Phrases p) {

		return phrasesRepository.save(p);
	}
}
