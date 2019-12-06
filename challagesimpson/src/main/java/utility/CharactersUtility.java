package utility;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import abstractClass.Utility;
import interfaces.IDataBase;
import model.Characters;
import model.Data;

public class CharactersUtility extends Utility implements IDataBase<Characters>  {

	@Override
	public Data<Characters> get() {
		Data<Characters> emp = null;
		try {
	   
		//create ObjectMapper instance
	    ObjectMapper objectMapper = objMapper;
	    
	    String charactersData = GetFile("Files/characters.json");
	    emp = objectMapper.readValue(charactersData, Data.class);
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return emp;
	}

	@Override
	public Characters getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Characters updateOrcreate(String id, Object obj) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Characters> detete(String id) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void GetObjectMapper(ObjectMapper objectMapper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GetObjectMapper(Gson gn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String GetFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object seedInMemoryDataBase(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
