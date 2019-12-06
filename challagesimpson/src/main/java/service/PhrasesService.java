package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Data;
import model.Phrases;
import repository.IPhrasesRepository;

@Service
public class PhrasesService implements IPharasesService {
	@Autowired
	private IPhrasesRepository phrasesRepository;

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
