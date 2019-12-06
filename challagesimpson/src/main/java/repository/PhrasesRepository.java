package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import interfaces.IDataBase;
import interfaces.IPhrasesRepository;
import model.Data;
import model.Phrases;

@Component
public class PhrasesRepository implements IPhrasesRepository {
	@Autowired
	IDataBase utility;

	@Override
	public Data<Phrases> findAll() {
		return utility.get();
	}

	@Override
	public Phrases findById(String id) {
		return utility.getById(id);
	}

	@Override
	public ArrayList<Phrases> deleteById(String id) {
		try {
			return utility.detete(id);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Phrases save(Phrases p) {
		try {
			return utility.updateOrcreate(p.get_id(), p);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
