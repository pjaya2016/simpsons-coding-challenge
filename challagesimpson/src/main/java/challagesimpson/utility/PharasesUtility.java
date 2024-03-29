package challagesimpson.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import challagesimpson.abstract_class.Utility;
import challagesimpson.interfaces.IDataBase;
import challagesimpson.datasim.DataBaseSim;
import model.Data;
import model.Phrases;

@Component
public class PharasesUtility extends Utility implements IDataBase<Phrases> 
{

	private DataBaseSim _dbs;
	
	public PharasesUtility(DataBaseSim DBS) 
	{
		_dbs = DBS;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Data<Phrases> get()
	{
		Data<Phrases> data = null;
		try {
	   
	    //create ObjectMapper instance
	    ObjectMapper objectMapper = objMapper;
	    
	    String phrasesData = (String) _dbs.GetData("Phrases_tbl");
	    data = objectMapper.readValue(phrasesData, Data.class);
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return data;
	}
	
	@Override
	public Phrases getById(String id)
	{		
		ArrayList<Object> json = (ArrayList<Object>)get().getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;		

		try {
			mapper.readValue(str, Phrases[].class);
			List<Phrases> phrasesLst = Arrays.asList(mapper.readValue(str, Phrases[].class));
			
			Phrases result = phrasesLst.stream()                        
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
	public Phrases updateOrcreate(String id,Object obj) throws JsonMappingException, JsonProcessingException 
	{
		Data<Phrases> data = get();
		ArrayList<Object> json = (ArrayList<Object>)data.getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;
		
		List<Phrases> phrases = Arrays.asList(mapper.readValue(str, Phrases[].class));
		
		Phrases objP = (Phrases) obj;
		if(getById(objP.get_id()) == null) 
		{
			
			ArrayList<Phrases> lst = new ArrayList<Phrases>(phrases);
			lst.add(objP);
			data.setData(lst);	
			_dbs.getDatabase().put("Phrases_tbl",gson.toJson(data));	
			return objP;
		}
		else 
		{
			Phrases p = phrases.stream()
					.filter(o -> id.equals(o.get_id()))
					.findAny()
					.orElse(null);
			
			int index = phrases.indexOf(p); // index
			
			phrases.set(index, (Phrases)obj);
			data.setData(new ArrayList<Phrases>(phrases));	
			_dbs.getDatabase().put("Phrases_tbl",gson.toJson(data));	  
			return (Phrases) data.getData().get(index);
		}	
	}
	
	@Override
	public ArrayList<Phrases> detete(String id) throws JsonMappingException, JsonProcessingException 
	{
		Data<Phrases> data = get();
		
		ArrayList<Object> json = (ArrayList<Object>)data.getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;
		
		mapper.readValue(str, Phrases[].class);
		List<Phrases> phrasesLst = Arrays.asList(mapper.readValue(str, Phrases[].class)).stream()
			    .filter(p -> !p.get_id().equals(id)).collect(Collectors.toList());
		
		data.setData(new ArrayList<Phrases>(phrasesLst));	
		_dbs.getDatabase().put("Phrases_tbl",gson.toJson(data));	  
		return data.getData();
	}	
}
