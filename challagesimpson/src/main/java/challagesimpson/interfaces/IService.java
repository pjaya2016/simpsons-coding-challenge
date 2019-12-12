package challagesimpson.interfaces;

import java.util.ArrayList;

import model.Data;
import model.Phrases;

public interface IService<T> {

	Data<T> findAll();
	 
	T findById(String id);

	ArrayList<T> deleteById(String id);
	
	T save(T p);

}