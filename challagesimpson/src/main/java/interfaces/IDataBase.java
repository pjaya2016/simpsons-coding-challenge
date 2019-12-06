package interfaces;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Data;
import model.Phrases;

public interface IDataBase {

	Data<Phrases> get();

	Phrases getById(String id);

	Phrases updateOrcreate(String id, Object obj) throws JsonMappingException, JsonProcessingException;

	ArrayList<Phrases> detete(String id) throws JsonMappingException, JsonProcessingException;

}