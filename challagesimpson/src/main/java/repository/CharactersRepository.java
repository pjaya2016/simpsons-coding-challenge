package repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Characters> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phrases save(Characters p) {
		// TODO Auto-generated method stub
		return null;
	}

}
