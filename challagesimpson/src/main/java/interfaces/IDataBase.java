package interfaces;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Data;
import model.Phrases;

public interface IDataBase<T> {

	Data<T> get();

	T getById(String id);

	T updateOrcreate(String id, Object obj) throws JsonMappingException, JsonProcessingException;

	ArrayList<T> detete(String id) throws JsonMappingException, JsonProcessingException;

}