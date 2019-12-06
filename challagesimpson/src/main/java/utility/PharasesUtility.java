package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import abstractClass.Utility;
import challagesimpson.Application;
import interfaces.IDataBase;
import model.Characters;
import model.Data;
import model.Phrases;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;

@Component
public class PharasesUtility extends Utility implements IDataBase<Phrases> 
{

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
	
	@Override
	public Data<Phrases> get()
	{
		Data<Phrases> emp = null;
		try {
	   
	    //create ObjectMapper instance
	    ObjectMapper objectMapper = objMapper;
	    
	    String phrasesData = (String) seedInMemoryDataBase("Phrases_tbl");
	    emp = objectMapper.readValue(phrasesData, Data.class);
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return emp;
	}
	
	@Override
	public Phrases getById(String id)
	{		
		ArrayList<Object> json = (ArrayList<Object>)get().getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;		

		try {
			Phrases[] pp1 = mapper.readValue(str, Phrases[].class);
			List<Phrases> ppl2 = Arrays.asList(mapper.readValue(str, Phrases[].class));
			
			Phrases result1 = ppl2.stream()                        
	                .filter(x -> x.get_id().equals(id))        
	                .findAny()                           
	                .orElse(null);  
			return result1; 
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}	
		return null;
	}
	
	protected String GetFile(String fileName)
	{
        ClassLoader classLoader = new Application().getClass().getClassLoader();
       
        File file = new File(classLoader.getResource(fileName).getFile());
		
        String content = "";
        try {
			 content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return content;
	}
	
	@Override
	public Phrases updateOrcreate(String id,Object obj) throws JsonMappingException, JsonProcessingException 
	{
		Data<Phrases> data = get();
		ArrayList<Object> json = (ArrayList<Object>)data.getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;
		
		List<Phrases> ppl2 = Arrays.asList(mapper.readValue(str, Phrases[].class));
		
		Phrases objP = (Phrases) obj;
		if(getById(objP.get_id()) == null) 
		{
			
			ArrayList<Phrases> lst = new ArrayList<Phrases>(ppl2);
			lst.add(objP);
			data.setData(lst);	
			database.put("Phrases_tbl",gson.toJson(data));	
			return objP;
		}
		else 
		{
			Phrases james = ppl2.stream()
					.filter(customer -> id.equals(customer.get_id()))
					.findAny()
					.orElse(null);
			
			int index = ppl2.indexOf(james); // index
			
			ppl2.set(index, (Phrases)obj);
			data.setData(new ArrayList<Phrases>(ppl2));	
			database.put("Phrases_tbl",gson.toJson(data));	  
			return james;
		}	
	}
	
	@Override
	public ArrayList<Phrases> detete(String id) throws JsonMappingException, JsonProcessingException 
	{
		Data<Phrases> data = get();
		
		ArrayList<Object> json = (ArrayList<Object>)data.getData();
		String str = gson.toJson(json);
		ObjectMapper mapper = objMapper;
		
		Phrases[] pp1 = mapper.readValue(str, Phrases[].class);
		List<Phrases> ppl2 = Arrays.asList(mapper.readValue(str, Phrases[].class)).stream()
			    .filter(p -> !p.get_id().equals(id)).collect(Collectors.toList());
		
		data.setData(new ArrayList<Phrases>(ppl2));	
		database.put("Phrases_tbl",gson.toJson(data));	  
		return data.getData();
	}
	
	protected Object seedInMemoryDataBase(String empId) {    
		      	    
		 if(!database.containsKey("Phrases_tbl")){
		  String phrasesData = GetFile("Files/phrases.json");   
	      database.put("Phrases_tbl",phrasesData);	  
	     }
	      return database.get(empId);		
	   }
	
}
