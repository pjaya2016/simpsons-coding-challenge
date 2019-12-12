package challagesimpson.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import challagesimpson.interfaces.IDataBase;
import challagesimpson.interfaces.IRepository;
import model.Data;
import model.Phrases;

@Repository
public class PhrasesRepository implements IRepository<Phrases> {
	@Autowired
	IDataBase<Phrases> pharasesUtility;

	@Override
	public Data<Phrases> findAll() {
		return pharasesUtility.get();
	}

	@Override
	public Phrases findById(String id) {
		return pharasesUtility.getById(id);
	}

	@Override
	public ArrayList<Phrases> deleteById(String id) {
		try {
			return pharasesUtility.detete(id);
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
			return pharasesUtility.updateOrcreate(p.get_id(), p);
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
