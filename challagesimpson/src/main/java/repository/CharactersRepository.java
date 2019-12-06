package repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;

import interfaces.IDataBase;
import interfaces.IRepository;
import model.Characters;
import model.Data;
import model.Phrases;

public class CharactersRepository implements IRepository<Characters>{

	@Autowired
	IDataBase<Characters> charactersUtility;
	
	@Override
	public Data<Characters> findAll() {
		return charactersUtility.get();
	}

	@Override
	public Characters findById(String id) {
		System.out.print(id);
		return charactersUtility.getById(id);
	}

	@Override
	public ArrayList<Characters> deleteById(String id) {
		try {
			return charactersUtility.detete(id);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Characters save(Characters p) {
		try {
			return charactersUtility.updateOrcreate(p.get_id(), p);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
