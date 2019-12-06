package interfaces;

import java.util.ArrayList;

import model.Data;
import model.Phrases;


public interface IRepository<T> {

	Data<T> findAll();

	T findById(String id);

	ArrayList<T> deleteById(String id);
	
	Phrases save(T p);

}