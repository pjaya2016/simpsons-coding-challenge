package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import abstract_class.Utility;
import interfaces.IDataBase;
import model.Characters;
import model.Data;

public class CharactersUtility extends Utility implements IDataBase<Characters>
{
	
	@SuppressWarnings("unchecked")
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

		ArrayList<Object> json = (ArrayList<Object>)get().getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;		

		try {
			mapper.readValue(str, Characters[].class);
			List<Characters> charactersLst = Arrays.asList(mapper.readValue(str, Characters[].class));
			
			Characters result = charactersLst.stream()                        
	                .filter(o -> o.get_id().equals(id))        
	                .findAny()                           
	                .orElse(null);  
			return result; 
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public Characters updateOrcreate(String id, Object obj) throws JsonMappingException, JsonProcessingException {
	    
		Data<Characters> data = get();
		ArrayList<Object> json = (ArrayList<Object>)data.getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;
		
		List<Characters> charactersLst = Arrays.asList(mapper.readValue(str, Characters[].class));
		
		Characters objP = (Characters) obj;
		if(getById(objP.get_id()) == null) 
		{
			ArrayList<Characters> lst = new ArrayList<Characters>(charactersLst);
			lst.add(objP);
			data.setData(lst);	
			database.put("Characters_tbl",gson.toJson(data));	
			return objP;
		}
		else 
		{
			Characters p = charactersLst.stream()
					.filter(o -> id.equals(o.get_id()))
					.findAny()
					.orElse(null);
			
			int index = charactersLst.indexOf(p); // index
			
			charactersLst.set(index, (Characters)obj);
			
			data.setData(new ArrayList<Characters>(charactersLst));
			
			database.put("Characters_tbl",gson.toJson(charactersLst));	  
			return (Characters) data.getData().get(index);
		}
	}

	@Override
	public ArrayList<Characters> detete(String id) throws JsonMappingException, JsonProcessingException {
	
		Data<Characters> data = get();
		
		ArrayList<Object> json = (ArrayList<Object>)data.getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;
		
		mapper.readValue(str, Characters[].class);
		List<Characters> charactersLst = Arrays.asList(mapper.readValue(str, Characters[].class)).stream()
			    .filter(p -> !p.get_id().equals(id)).collect(Collectors.toList());
		
		data.setData(new ArrayList<Characters>(charactersLst));	
		database.put("Phrases_tbl",gson.toJson(data));	  
		return data.getData();
	}

	@Autowired
	public void GetObjectMapper(ObjectMapper objectMapper) 
	{
		objMapper = objectMapper;
	}
	
	@Autowired
	public void GetObjectMapper(Gson gn) 
	{
		gson = gn;
	}
}
